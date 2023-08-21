package com.example.CelluloidInsight.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("watchlist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWatchlist {
    @Id Integer userId;
    List<String> movieIds;
}
