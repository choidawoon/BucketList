package com.toy.Backend.service.Impl;


import com.toy.Backend.entity.Post;
import com.toy.Backend.entity.PostImage;
import com.toy.Backend.repository.PostImageRepository;
import com.toy.Backend.service.FileService;
import com.toy.Backend.service.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final S3Service s3Service;
    private final PostImageRepository postImageRepository;

    @Override
    public boolean fileExtensionCheck(MultipartFile[] files) throws Exception {
        log.debug("FileService fileExtensionCheck call");

        for(MultipartFile mfile : files){ //파일 확장자 검사
            String originFileName = mfile.getOriginalFilename();
            String extension = originFileName.substring(originFileName.length()-3);

            if(!(extension.equals("jpg") || extension.equals("png") || extension.equals("JPG") || extension.equals("PNG")
                    || extension.equals("jpeg") || extension.equals("JPEG")))
                return false;
        }
        return true;
    }

    @Override
    public void postFileSave(Post post, MultipartFile[] files) throws Exception {
        log.debug("FileService PostFileSave call");

        for (MultipartFile mfile : files) {
            String imgURL = s3Service.upload(mfile);  //S3에 파일 업로드 후 URL 가져오기
            PostImage file = PostImage.builder()
                    .path(imgURL)
                    .post(post).build();
            postImageRepository.save(file);
        }

    }

    @Override
    public void postFileDelete(List<PostImage> files) throws Exception {
        log.debug("FileService donationFileDelete call");

        for(PostImage file : files) {
            //S3에서 파일 삭제
            s3Service.delete(file.getPath());
            //파일 테이블에서 삭제
            postImageRepository.deleteById(file.getId());
        }
    }

    @Override
    public List<String> getPostFileList(List<PostImage> files) throws Exception {
        log.debug("FileService getFileList call");

        List<String> images = new ArrayList<>();
        for(PostImage i : files) {
            images.add(i.getPath());
        }
        return images;
    }
}
