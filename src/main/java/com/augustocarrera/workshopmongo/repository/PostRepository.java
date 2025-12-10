package com.augustocarrera.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.augustocarrera.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String>{

    List<Post> findByTitleContaining(String text);
}
