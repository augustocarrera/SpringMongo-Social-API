package com.augustocarrera.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.augustocarrera.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String>{

}
