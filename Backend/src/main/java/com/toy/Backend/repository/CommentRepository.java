package com.toy.Backend.repository;

import com.toy.Backend.entity.Comment;
import com.toy.Backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByPostOrderByIdDesc(Post post);
}
