package com.example.CelluloidInsight.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProducerDto {
    private String id;
    private String movieId;
    private Double rating;
}
