package com.toy.Backend.service;

import com.toy.Backend.dto.PostReqDto;
import com.toy.Backend.dto.PostUpdateReqDto;
import com.toy.Backend.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PostService {
    //후기 글 등록
    Map<String, Object> registerPost(PostReqDto postReqDto, MultipartFile[] files) throws Exception;

    //후기 글 조회
    Map<String, Object> getPost(int id) throws Exception;

    //후기 글 수정
    Map<String, Object> updatePost(PostUpdateReqDto postUpdateReqDto, MultipartFile[] files) throws Exception;

    //후기 글 삭제
    Map<String, Object> deletePost(int id) throws Exception;

    //후기 글 목록
    Map<String, Object> listPost (String order, int page) throws Exception;

    //목록 만들기
    Map<String, Object> makeListPost (Page<Post> posts) throws Exception;
}
