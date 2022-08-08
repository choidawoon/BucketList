package com.toy.Backend.repository;

import com.toy.Backend.entity.BucketlistTag;
import com.toy.Backend.entity.BucketlistTagId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketlistTagRepository extends JpaRepository<BucketlistTag, BucketlistTagId> {
}
