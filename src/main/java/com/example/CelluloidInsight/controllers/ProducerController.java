package com.example.CelluloidInsight.controllers;

import com.example.CelluloidInsight.Dto.ProducerDto;
import com.example.CelluloidInsight.services.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;
    @PostMapping("/produce-rating-message")
    public String produceMessages(ProducerDto producerDto){
        producerService.produceCreateRatingMessage(producerDto);
        return "created";
    }
}
