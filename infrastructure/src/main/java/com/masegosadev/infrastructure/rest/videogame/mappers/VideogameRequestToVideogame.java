package com.masegosadev.infrastructure.rest.videogame.mappers;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.infrastructure.rest.videogame.model.VideogameRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class VideogameRequestToVideogame implements Function<VideogameRequest, Videogame> {

    @Override
    public Videogame apply(VideogameRequest videogameRequest) {

        Videogame videogame = new Videogame(videogameRequest.getName(), videogameRequest.getImageUrl(), videogameRequest.getPlatform());
        return videogame;
    }
}
