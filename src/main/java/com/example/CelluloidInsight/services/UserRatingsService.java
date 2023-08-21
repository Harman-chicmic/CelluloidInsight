package com.example.CelluloidInsight.services;

import com.example.CelluloidInsight.Dto.MovieRating;
import com.example.CelluloidInsight.documents.UserRatings;
import com.example.CelluloidInsight.documents.UserWatchlist;
import com.example.CelluloidInsight.repositories.FilmRepository;
import com.example.CelluloidInsight.repositories.UserRatingsRepository;
import com.example.CelluloidInsight.repositories.UserWatchlistRepository;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserRatingsService {
    private final UserRatingsRepository userRatingsRepository;
    private final FilmRepository filmRepository;
    private final MongoTemplate mongoTemplate;
    public UserRatings createForUserId(Integer userId){
        return userRatingsRepository.save(new UserRatings(userId,new ArrayList<>()));
    }
    public UpdateResult rateMovie(MovieRating movieRating,Integer userId){
        UpdateResult updateResult = mongoTemplate.updateFirst(Query.query(Criteria.where("userId").is(userId)),
                new Update().push("movieRating",movieRating), UserRatings.class
        );
        return updateResult;
    }
}
