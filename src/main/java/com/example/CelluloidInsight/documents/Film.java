package com.example.CelluloidInsight.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("films")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    private String id;
    private String name;
    private long numberOfRatings;
    private double rating;
}
