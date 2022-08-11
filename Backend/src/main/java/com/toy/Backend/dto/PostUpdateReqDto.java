package com.toy.Backend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "후기 글 수정")
@Getter
public class PostUpdateReqDto {

    @ApiModelProperty(value = "고유번호")
    @NotBlank(message = "후기글 고유번호")
    private int id;

    @ApiModelProperty(value = "제목")
    @NotBlank(message = "제목을 입력해주세요")
    private String title;

    @ApiModelProperty(value = "내용")
    @NotBlank(message = "내용을 입력해주세요")
    private String content;

    @ApiModelProperty(value = "버킷리스트 고유번호")
    private int bucketlistId;

    @ApiModelProperty(value = "회원 고유번호")
    private String memberId;
}
