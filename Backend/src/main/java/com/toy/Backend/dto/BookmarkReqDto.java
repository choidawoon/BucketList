package com.toy.Backend.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@ApiModel(value = "북마크 등록")
@Getter
public class BookmarkReqDto {

    private int bucketlistId;
    private String memberId;
}
