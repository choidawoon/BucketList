package com.toy.Backend.repository;

import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketlistRepository extends JpaRepository<Bucketlist, Integer>{

    List<Bucketlist> findByMember(Member member);
}