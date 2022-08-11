package com.toy.Backend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@ApiModel(value = "CommentResDto", description = "댓글 응답")
public class CommentResDto {

    @ApiModelProperty(value = "번호", example = "1")
    private Integer id;

    @ApiModelProperty(value = "내용", example = "댓글입니다")
    private String content;

    @ApiModelProperty(value = "날짜", example = "2022-08-11 23:23:13")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "회원 ID", example = "U001")
    private String memberId;

    @ApiModelProperty(value = "회원 이름", example = "김개똥")
    private String memberName;

    @ApiModelProperty(value = "회원 이미지", example = "")
    private String memberImage;

}
