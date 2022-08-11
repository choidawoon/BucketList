package com.toy.Backend.repository;

import com.toy.Backend.entity.PostImage;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Integer> {
}
