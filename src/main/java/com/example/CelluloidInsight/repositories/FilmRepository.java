package com.example.CelluloidInsight.repositories;

import com.example.CelluloidInsight.documents.Film;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository public interface FilmRepository extends MongoRepository<Film,String> {
}
