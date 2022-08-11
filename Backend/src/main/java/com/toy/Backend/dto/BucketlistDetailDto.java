package com.toy.Backend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@Builder
@ApiModel(value = "BucketlistDetailDto", description = "버킷리스트 상세보기")
public class BucketlistDetailDto {

    @ApiModelProperty(value = "번호", example="1")
    private Integer id;

    @ApiModelProperty(value = "글쓴이", example = "U001")
    private String memberId;

    @ApiModelProperty(value = "글쓴이", example = "김개똥")
    private String memberName;

    @ApiModelProperty(value = "제목", example = "패러글라이딩")
    private String title;

    @ApiModelProperty(value = "내용", example = "패러글라이딩 하기")
    private String content;

    @ApiModelProperty(value = "타입", notes = "0:달성형, 1:기록형")
    private Integer type;

    @ApiModelProperty(value = "카테고리", name = "name", example = "취미")
    private String category;

    @ApiModelProperty(value = "태그", example = "[\"태그1\",\"태그2\"]")
    private List<String> tag;

    @Nullable
    @ApiModelProperty(value = "")
    private Integer totalCount;

    @Nullable
    @ApiModelProperty(value = "")
    private Integer count;

    @ApiModelProperty(value = "")
    private Integer position;

    @ApiModelProperty(value = "완료 여부", example = "true")
    private Boolean check;

    @ApiModelProperty(value = "북마크 여부", example = "true")
    private Boolean bookmark;
}