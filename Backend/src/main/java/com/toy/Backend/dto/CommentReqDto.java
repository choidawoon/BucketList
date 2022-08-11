package com.toy.Backend.dto;

import com.toy.Backend.entity.Comment;
import com.toy.Backend.entity.Member;
import com.toy.Backend.entity.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

public class CommentReqDto {

    @Data
    @ApiModel(value = "CommentRegisterDto", description = "댓글 등록 요청")
    public static class CommentRegisterDto{

        @ApiModelProperty(value = "후기 ID")
        private Integer postId;

        @ApiModelProperty(value = "내용", example = "댓글입니다")
        private String content;

        public Comment toEntity(Member member, Post post){
            return Comment.builder()
                    .member(member)
                    .post(post)
                    .content(content)
                    .build();
        }
    }

    @Data
    @ApiModel(value = "CommentUpdateDto", description = "댓글 수정 요청")
    public static class CommentUpdateDto{

        private Integer commentId;
        private String content;
    }
}
