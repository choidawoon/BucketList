package com.toy.Backend.controller;

import com.toy.Backend.dto.BucketlistRegisterDto;
import com.toy.Backend.service.BucketlistService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/bucketlist")
public class BucketlistController {

    private BucketlistService bucketlistService;

    @Autowired
    public BucketlistController(BucketlistService bucketlistService) {
        this.bucketlistService = bucketlistService;
    }

    @ApiOperation(value="버킷리스트 등록", notes = "달성형은 totalcount를 null로 설정")
    @PostMapping
    public ResponseEntity registerBucketlist(@RequestBody @ApiParam(value = "", required = true) BucketlistRegisterDto bucketlistReqDto){
        log.info("registerBucketlist");

        bucketlistService.registerBucketlist(bucketlistReqDto);

        return new ResponseEntity("버킷리스트 등록 완료", HttpStatus.OK);
    }
}