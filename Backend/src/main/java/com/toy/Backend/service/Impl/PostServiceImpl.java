package com.toy.Backend.service.Impl;

import com.toy.Backend.dto.ListPostResDto;
import com.toy.Backend.dto.PostReqDto;
import com.toy.Backend.dto.PostResDto;
import com.toy.Backend.dto.PostUpdateReqDto;
import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.Member;
import com.toy.Backend.entity.Post;
import com.toy.Backend.enumClass.Order;
import com.toy.Backend.repository.BucketlistRepository;
import com.toy.Backend.repository.MemberRepository;
import com.toy.Backend.repository.PostRepository;
import com.toy.Backend.service.FileService;
import com.toy.Backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final FileService fileService;
    private final MemberRepository memberRepository;
    private final BucketlistRepository bucketlistRepository;

    @Override
    public Map<String, Object> registerPost(PostReqDto postReqDto, MultipartFile[] files) throws Exception {
        log.info("PostService registerPost call");

        Map<String, Object> resultMap = new HashMap<>();

        if(files != null && !fileService.fileExtensionCheck(files)){
            resultMap.put("message", "파일확장자 불량");
            return resultMap;
        }

        Optional<Member> member = memberRepository.findById(postReqDto.getMemberId());
        Optional<Bucketlist> bucketlist = bucketlistRepository.findById(postReqDto.getBucketlistId());

        Post post = Post.builder()
                .member(member.get())
                .bucketlist(bucketlist.get())
                .title(postReqDto.getTitle())
                .content(postReqDto.getContent())
                .build();
        postRepository.save(post);

        if(files != null){
            fileService.postFileSave(post, files);
        }

        resultMap.put("message", "성공");
        resultMap.put("Id", post.getId());

        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> getPost(int id) throws Exception {
        log.info("PostService getPost call");

        Map<String, Object> resultMap = new HashMap<>();

        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent()){
            resultMap.put("message", "게시물 없음");
            return resultMap;
        }

        PostResDto postResDto = PostResDto.builder()
                .title(post.get().getTitle())
                .content(post.get().getContent())
                .memberId(post.get().getMember().getId())
                .bucketlistId(post.get().getBucketlist().getId())
                .createDate(post.get().getCreateDate())
                .images(fileService.getPostFileList(post.get().getImages())).build();

        resultMap.put("message", "조회 성공");
        resultMap.put("post", postResDto);
        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> updatePost(PostUpdateReqDto postUpdateReqDto, MultipartFile[] files) throws Exception {

        log.info("PostService updatePost call");

        Map<String, Object> resultMap = new HashMap<>();

        if(files != null && !fileService.fileExtensionCheck(files)) {
            resultMap.put("message", "파일확장자 불량");
            return resultMap;
        }

        Optional<Post> post = postRepository.findById(postUpdateReqDto.getId());

        post.get().changeTitle(postUpdateReqDto.getTitle());
        post.get().changeContent(postUpdateReqDto.getContent());
        //post.get().setTitle(postUpdateReqDto.getTitle());
        //post.get().setContent(postUpdateReqDto.getContent());

        if(files==null){
            fileService.postFileDelete(post.get().getImages());
        }
        else{
            fileService.postFileDelete(post.get().getImages());
            fileService.postFileSave(post.get(), files);
        }

        resultMap.put("message", "성공");
        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> deletePost(int id) throws Exception {
        log.info("PostService deletePost call");

        Map<String, Object> resultMap = new HashMap<>();

        Optional<Post> post = postRepository.findById(id);
        if(!post.isPresent()){
            resultMap.put("message", "게시물 없음");
            return resultMap;
        }

        postRepository.deleteById(id);

        resultMap.put("message", "삭제 성공");
        return resultMap;
    }

    @Override
    public Map<String, Object> listPost(String order, int page) throws Exception {
        log.info("PostService listPost call");

        Sort sort = getOrder(order);
        Page<Post> posts;
        posts = postRepository.findAll(PageRequest.of(page, 10, sort));

        return makeListPost(posts);
    }

    @Override
    public Map<String, Object> makeListPost(Page<Post> posts) throws Exception {
        log.info("PostService makePostList call");

        Map<String, Object> resultMap = new HashMap<>();

        if(posts.isEmpty()){
            resultMap.put("message", "게시물 없음");
            return resultMap;
        }

        List<ListPostResDto> list = new ArrayList<>();

        for(Post post : posts){

            ListPostResDto listPostResDto = ListPostResDto.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .createDate(post.getCreateDate())
                    .memberId(post.getMember().getId())
                    .bucketlistId(post.getBucketlist().getId()).build();
            list.add(listPostResDto);
        }

        resultMap.put("listPost", list);
        resultMap.put("totalPage", posts.getTotalPages());
        resultMap.put("message", "성공");

        return resultMap;
    }

    public Sort getOrder(String order){
        if(order.equals(Order.최신순.toString())) {return  Sort.by("id").descending();}
        else{return Sort.by("id").ascending();}
    }

}