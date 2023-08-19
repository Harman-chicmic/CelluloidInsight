package com.example.CelluloidInsight.controllers;

import com.example.CelluloidInsight.Dto.MovieRating;
import com.example.CelluloidInsight.services.UserRatingsService;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserRatingsController {
    private final UserRatingsService userRatingsService;
    @PostMapping("test-rating") public UpdateResult rateFilm(@RequestBody MovieRating movieRating, @RequestHeader Integer userId){
        return userRatingsService.rateMovie(movieRating, userId);
    }
}
