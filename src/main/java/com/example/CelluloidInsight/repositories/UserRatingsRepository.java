package com.example.CelluloidInsight.repositories;

import com.example.CelluloidInsight.documents.UserRatings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository public interface UserRatingsRepository extends MongoRepository<UserRatings,String> {
}
