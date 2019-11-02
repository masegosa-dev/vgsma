package com.masegosadev.infrastructure.rest.videogame.mappers;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import com.masegosadev.infrastructure.rest.videogame.model.PlaformResponse;
import com.masegosadev.infrastructure.rest.videogame.model.VideogameResponse;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class VideogameToVideogameResponse implements Function<Videogame, VideogameResponse> {

    private final NamePlatformToPlatformResponse namePlatformToPlatformResponse;

    public VideogameToVideogameResponse(NamePlatformToPlatformResponse namePlatformToPlatformResponse) {
        this.namePlatformToPlatformResponse = namePlatformToPlatformResponse;
    }

    @Override
    public VideogameResponse apply(Videogame videogame) {
        Set<PlaformResponse> platformEntities = videogame.getPlatforms().stream().map(namePlatformToPlatformResponse).collect(Collectors.toSet());
        return new VideogameResponse(videogame.getName(), videogame.getImageUrl(), platformEntities);
    }
}
