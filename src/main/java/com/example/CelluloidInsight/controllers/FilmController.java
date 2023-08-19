package com.example.CelluloidInsight.controllers;

import com.example.CelluloidInsight.documents.Film;
import com.example.CelluloidInsight.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FilmController {
    private final FilmService filmService;
    @GetMapping("/show-all")
    public List<Film> showAll(){
        return filmService.returnAll();
    }
}
