package com.example.CelluloidInsight.services;

import com.example.CelluloidInsight.ExceptionHandling.ApiException;
import com.example.CelluloidInsight.documents.Film;
import com.example.CelluloidInsight.documents.UserRatings;
import com.example.CelluloidInsight.documents.UserWatchlist;
import com.example.CelluloidInsight.repositories.FilmRepository;
import com.example.CelluloidInsight.repositories.UserWatchlistRepository;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WatchlistService {
    private final UserWatchlistRepository watchlistRepository;
    private final MongoTemplate mongoTemplate;
    private final FilmRepository filmRepository;
    public List<Film> returnWatchlist(Integer userId){
        Query query = new Query(Criteria.where("userId").is(userId));
        List<String> movieIds = mongoTemplate.findOne(query,UserWatchlist.class).getMovieIds();
        return filmRepository.findAllById(movieIds);
    }
    public UpdateResult addFilm(Integer userId, String movieId){
        boolean filmExists = filmRepository.existsById(movieId);
        if(filmExists) {
            Query query = new Query(Criteria.where("userId").is(userId));
            Update update = new Update().addToSet("movieIds", movieId);
            return mongoTemplate.updateFirst(query, update, UserWatchlist.class);
        }
        else throw new ApiException(HttpStatus.NOT_FOUND,"Invalid movieId");
    }
    public UpdateResult removeFromWatchlist(Integer userId, String movieId){
        Query query = new Query(Criteria.where("userId").is(userId));
        Update update = new Update().pull("movieIds", movieId);
        return mongoTemplate.updateFirst(query, update, UserWatchlist.class);
    }
    public void deleteFromDB(Integer userId){
        Query query = new Query(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query,UserWatchlist.class);
    }
}
