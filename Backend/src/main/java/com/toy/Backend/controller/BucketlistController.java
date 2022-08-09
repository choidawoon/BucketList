package com.toy.Backend.controller;

import com.toy.Backend.dto.BucketlistDetailDto;
import com.toy.Backend.dto.BucketlistRegisterDto;
import com.toy.Backend.service.BucketlistService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @ApiOperation(value="버킷리스트 조회")
    @GetMapping(value = {"/list/{memerId}", "/list"})
    public ResponseEntity getBucketlist(@ApiParam(value = "조회할 memberId", example = "U001") @PathVariable(required = false) String memerId,
                                        @ApiParam(value = "조회 타입", required = true) @RequestParam String type) {
        Map<String, Object> resultMap = new HashMap<>();

        //페이징 개수 받기?
        System.out.println(memerId + "의 버킷리스트 조회 : " + type);

        resultMap = bucketlistService.getBucketlist(memerId, type);

        return new ResponseEntity(resultMap, HttpStatus.OK);
    }

    @ApiOperation(value="버킷리스트 상세 조회")
    @GetMapping("/detail/{bucketlistId}")
    public ResponseEntity getDetail(@ApiParam(value = "조회할 bucketlistId", required = true) @PathVariable Integer bucketlistId) {

        BucketlistDetailDto bucketlistDetailDto = bucketlistService.getBucketlistDetail(bucketlistId);

        return new ResponseEntity(bucketlistDetailDto, HttpStatus.OK);
    }
}