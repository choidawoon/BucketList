package com.toy.Backend.controller;

import com.toy.Backend.dto.CommentReqDto.*;
import com.toy.Backend.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {this.commentService = commentService;}

    @ApiOperation(value="댓글 등록")
    @PostMapping
    public ResponseEntity registerComment(@RequestBody @ApiParam(required = true) CommentRegisterDto commentRegisterDto){

        commentService.registerComment(commentRegisterDto);

        return new ResponseEntity("댓글 등록 완료", HttpStatus.OK);
    }

    @ApiOperation(value="댓글 조회")
    @GetMapping("/{postId}")
    public ResponseEntity getCommentList(@ApiParam(value = "조회할 postId", required = true) @PathVariable Integer postId){
        Map<String, Object> resultMap = new HashMap<>();

        resultMap = commentService.getCommentList(postId);

        return new ResponseEntity(resultMap, HttpStatus.OK);
    }

    @ApiOperation(value="댓글 수정")
    @PutMapping
    public ResponseEntity updateComment(@RequestBody @ApiParam(required = true) CommentUpdateDto commentUpdateDto){

        commentService.updateComment(commentUpdateDto);

        return new ResponseEntity("댓글 수정 완료", HttpStatus.OK);
    }

    @ApiOperation(value="댓글 삭제")
    @DeleteMapping("{commentId}")
    public ResponseEntity deleteComment(@ApiParam(value = "삭제할 commentId", required = true) @PathVariable Integer commentId){

        commentService.deleteComment(commentId);

        return new ResponseEntity("댓글 삭제 완료", HttpStatus.OK);
    }
}
