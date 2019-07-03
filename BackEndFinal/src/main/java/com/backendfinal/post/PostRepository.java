package com.backendfinal.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendfinal.post.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
