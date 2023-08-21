package com.example.CelluloidInsight.controllers;

import com.example.CelluloidInsight.documents.Film;
import com.example.CelluloidInsight.documents.UserRatings;

import com.example.CelluloidInsight.documents.UserWatchlist;
import com.example.CelluloidInsight.repositories.UserWatchlistRepository;
import com.example.CelluloidInsight.services.WatchlistService;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/film")
public class WatchlistController {
    private final UserWatchlistRepository userWatchlistRepository;
    private final WatchlistService watchlistService;
    @PostMapping("/watchlist")
    public Boolean createAtSignup(@RequestHeader Integer userId){
        userWatchlistRepository.insert(new UserWatchlist(userId,new ArrayList<>()));
        return true;
    }
    @PostMapping("/watchlist/{movieId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public UpdateResult addToWatchList(@PathVariable String movieId, @RequestHeader Integer userId){
        return watchlistService.addFilm(userId, movieId);
    }
    @GetMapping("/view-list")
    public List<Film> returnAll(@RequestHeader Integer userId){
        return watchlistService.returnWatchlist(userId);
    }
    @PutMapping("/remove-film/{movieId}")
    public UpdateResult removeFromList(@PathVariable String movieId,@RequestHeader Integer userId){
        return watchlistService.removeFromWatchlist(userId, movieId);
    }
}
