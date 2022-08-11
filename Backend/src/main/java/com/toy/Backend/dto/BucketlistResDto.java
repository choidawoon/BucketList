package com.toy.Backend.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "BucketlistResDto", description = "버킷리스트 응답")
public class BucketlistResDto {

    @ApiModelProperty(value = "번호", example = "1")
    private Integer id;

    @ApiModelProperty(value = "제목", example = "패러글라이딩")
    private String title;

    @ApiModelProperty(value = "위치", example = "9")
    private Integer position;

    @ApiModelProperty(value = "완료여부", example = "true")
    private Boolean check;
}
