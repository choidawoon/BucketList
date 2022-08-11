package com.toy.Backend.service;

import com.toy.Backend.dto.CommentReqDto;
import com.toy.Backend.dto.CommentResDto;
import com.toy.Backend.entity.Comment;
import com.toy.Backend.entity.Member;
import com.toy.Backend.entity.Post;
import com.toy.Backend.repository.CommentRepository;
import com.toy.Backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MemberService memberService;

    public void registerComment(CommentReqDto commentReqDto){

        //시큐리티 적용 전 임시 회원
        Member member = memberService.getMember("U001");

        Post post = postRepository.findById(commentReqDto.getPostId()).get();

        Comment comment = commentReqDto.toEntity(member, post);
        commentRepository.save(comment);
    }

    public Map<String, Object> getCommentList(Integer postId){
        Map<String, Object> resultMap = new HashMap<>();

        Post post = postRepository.findById(postId).get();

        List<Comment> commentEntityList = commentRepository.findByPostOrderByIdDesc(post);
        List<CommentResDto> commentResDtos = commentEntityList.stream()
                .filter(comment -> !comment.getMember().isDeleted())
                .map(comment -> CommentResDto.builder()
                        .id(comment.getId())
                        .content(comment.getContent())
                        .createDate(comment.getCreateDate())
                        .memberId(comment.getMember().getId())
                        .memberName(comment.getMember().getName())
                        .memberImage(comment.getMember().getImage())
                        .build())
                .collect(Collectors.toList());


        resultMap.put("commentList", commentResDtos);
        resultMap.put("message", "댓글 조회 성공");

        return resultMap;
    }
}
