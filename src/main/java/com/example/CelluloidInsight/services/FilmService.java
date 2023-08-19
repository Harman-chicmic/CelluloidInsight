package com.example.CelluloidInsight.services;

import com.example.CelluloidInsight.documents.Film;
import com.example.CelluloidInsight.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    private final MongoTemplate mongoTemplate;
    public List<Film> returnAll(){
        return mongoTemplate.find(Query.query(new Criteria()), Film.class);
    }
    public Film getFilmById(String movieId){
        Query query = Query.query(Criteria.where("id").is(movieId));
        if(mongoTemplate.exists(query, Film.class)){
            return mongoTemplate.findOne(query,Film.class);
        }
        return null;
    }
    public boolean checkIfFilmExists(String movieId){
        Query query = Query.query(Criteria.where("id").is(movieId));
        return mongoTemplate.exists(query, Film.class);
    }
    public Film createFilm(Film film){
        return filmRepository.save(film);
    }
}
