package com.toy.Backend.controller;

import com.toy.Backend.dto.PostReqDto;
import com.toy.Backend.dto.PostUpdateReqDto;
import com.toy.Backend.service.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin(origins = {"*"}, maxAge = 6000)
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "후기 글 등록")
    @PostMapping
    public ResponseEntity registerPost(@RequestPart PostReqDto postReqDto, @RequestPart(required = false)MultipartFile[] files){
        log.info("PostController registerPost call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED;

        try {
            resultMap = postService.registerPost(postReqDto, files);
        }catch (Exception e){
            log.error(e.getMessage());
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);
    }

    @ApiOperation(value = "후기 글 조회")
    @GetMapping("{id}")
    public ResponseEntity getPost(@PathVariable int id){
        log.info("PostController getPost call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        try {
            resultMap = postService.getPost(id);
        } catch (Exception e){
            log.error(e.getMessage());
            resultMap.put("message", "error");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);

    }

    @ApiOperation(value = "봉사 글 수정")
    @PutMapping
    public ResponseEntity updatePost(@RequestPart PostUpdateReqDto postUpdateReqDto, @RequestPart(required = false) MultipartFile[] files){
        log.info("PostController updatePost call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.CREATED;
        try {
            resultMap = postService.updatePost(postUpdateReqDto, files);
        } catch (Exception e){
            log.error(e.getMessage());
            resultMap.put("message", "후기 글 수정 실패");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);
    }

    @ApiOperation(value = "봉사 글 삭제")
    @DeleteMapping("{id}")
    public ResponseEntity deleteVolunteer(@PathVariable int  id){
        log.info("PostController deletePost call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.OK;
        try {
            resultMap = postService.deletePost(id);
        }catch (Exception e){
            log.error(e.getMessage());

            resultMap.put("message", "실패");
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);
    }

    @GetMapping("/")
    public ResponseEntity listPost(@RequestParam(required = false,defaultValue = "최신순") String order,@RequestParam(defaultValue = "1") int page){

        log.info("PostController listPost call");

        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        try {
            resultMap = postService.listPost(order, page-1);
        }catch (Exception e){
            log.info(e.getMessage());
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity(resultMap, status);
    }

}
