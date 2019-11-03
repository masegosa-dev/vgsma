package com.masegosadev.infrastructure.rest.videogame.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
public class VideogameRequest {

    @NotEmpty
    String name;
    String imageUrl;
    @NotEmpty
    Set<String> platform;
}
