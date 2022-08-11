package com.toy.Backend.repository;

import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.BucketlistTag;
import com.toy.Backend.entity.BucketlistTagId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketlistTagRepository extends JpaRepository<BucketlistTag, BucketlistTagId> {

    List<BucketlistTag> findByBucketlistTagId_Bucketlist(Bucketlist bucketlist);
}
