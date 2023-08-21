package com.example.CelluloidInsight.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProducerDto {

    private Integer userId;
    private String movieId;
    private Integer rating;
    private Integer difference;

}
