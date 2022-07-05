package com.study.dockernetwork.repository;

import com.study.dockernetwork.model.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FavoriteRepository extends MongoRepository<Favorite, String> {
}
