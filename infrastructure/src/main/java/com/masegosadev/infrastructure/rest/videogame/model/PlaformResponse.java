package com.masegosadev.infrastructure.rest.videogame.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaformResponse {

    private String name;

    private String imageUrl;
}
