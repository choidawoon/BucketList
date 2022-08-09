package com.toy.Backend.repository;

import com.toy.Backend.entity.Bookmark;
import com.toy.Backend.entity.Bucketlist;
import com.toy.Backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Integer> {

    Optional<Bookmark> findByBucketlistAndMember(Bucketlist bucketlist, Member member);
}
