package com.toy.Backend.repository;

import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BucketlistRepository extends JpaRepository<Bucketlist, Integer>{

    List<Bucketlist> findByMember(Member member);

    @Modifying
    @Query("update Bucketlist b set b.position = 0 where b.member = :member")
    int initPosition(@Param("member") Member member);
}