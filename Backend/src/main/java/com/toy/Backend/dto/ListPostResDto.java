package com.toy.Backend.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ListPostResDto {

    private String title;

    @ApiModelProperty(value = "내용")
    private String content;

    @ApiModelProperty(value = "회원 id")
    private String memberId;

    @ApiModelProperty(value = "파일")
    private List<String> images;

    private LocalDateTime createDate;

    private int bucketlistId;

}
