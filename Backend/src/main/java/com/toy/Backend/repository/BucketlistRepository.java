package com.toy.Backend.repository;

import com.toy.Backend.entity.Bucketlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketlistRepository extends JpaRepository<Bucketlist, Integer>{
}