package com.toy.Backend.dto;

import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.Member;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@ApiModel(value = "BucketlistRegisterDto", description = "버킷리스트 등록 요청")
public class BucketlistRegisterDto {

    @ApiModelProperty(value = "제목", example = "패러글라이딩")
    private String title;

    @ApiModelProperty(value = "내용", example = "패러글라이딩 하기")
    private String content;

    @ApiModelProperty(value = "타입")
    private Integer type;

    @ApiModelProperty(value = "카테고리", name = "name", example = "취미")
    private String category;

    @ApiModelProperty(value = "태그", example = "[\"태그1\",\"태그2\"]")
    private List<String> tag;

    @Nullable
    @ApiModelProperty(value = "")
    private Integer totalCount;

    public Bucketlist toEntity(Member member){
        return Bucketlist.builder()
                .member(member)
                .title(title)
                .content(content)
                .type(type)
                .category(category)
                .totalCount(totalCount)
                .build();
    }
}
