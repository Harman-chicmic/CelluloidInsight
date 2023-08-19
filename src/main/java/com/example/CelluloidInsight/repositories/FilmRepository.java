package com.example.CelluloidInsight.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository public interface FilmRepository extends MongoRepository<FilmRepository,String> {
}
