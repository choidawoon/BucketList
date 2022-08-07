package com.toy.Backend.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BucketlistTag {

    @EmbeddedId
    private BucketlistTagId bucketlistTagId;
}