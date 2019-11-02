package com.masegosadev.infrastructure.rest.videogame.model;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
public class VideogameResponse {

    String name;
    String imageUrl;
    Set<PlaformResponse> platforms; //TODO Change to PlatformResponse
}
