package com.example.CelluloidInsight.documents;

import com.example.CelluloidInsight.Dto.MovieRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("userRatings")
@Data
@AllArgsConstructor
public class UserRatings {
    @Id Integer userId;
    List<MovieRating> movieRatings;
}
