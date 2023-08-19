package com.example.CelluloidInsight.services;

import com.example.CelluloidInsight.repositories.FilmRepository;
import com.example.CelluloidInsight.repositories.UserRatingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRatingsService {
    private final UserRatingsRepository userRatingsRepository;
    private final FilmRepository filmRepository;
}
