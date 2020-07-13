
package com.molinaromarcos.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.molinaromarcos.springmongodb.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	

}