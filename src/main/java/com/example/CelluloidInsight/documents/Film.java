package com.example.CelluloidInsight.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("films")
@Data
@AllArgsConstructor
public class Film {
    @Id
    private String id;
    private String name;
    private long numberOfRatings;
    private double rating;
}
