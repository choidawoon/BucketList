package com.toy.Backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ListBookmarkResDto {

    int id;
    int bucketlistId;
    String memberId;

}
