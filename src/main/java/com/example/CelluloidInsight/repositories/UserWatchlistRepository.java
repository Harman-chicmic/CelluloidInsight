package com.example.CelluloidInsight.repositories;

import com.example.CelluloidInsight.documents.UserWatchlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserWatchlistRepository extends MongoRepository<UserWatchlist,String> {
}
