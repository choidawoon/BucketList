package com.toy.Backend.service;

import com.toy.Backend.entity.Post;
import com.toy.Backend.entity.PostImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    boolean fileExtensionCheck(MultipartFile[] files) throws Exception;

    void postFileSave(Post post, MultipartFile[] files) throws Exception;

    void postFileDelete(List<PostImage> files) throws Exception;

    List<String> getPostFileList(List<PostImage> files) throws Exception;

}
