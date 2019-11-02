package com.masegosadev.infrastructure.rest.videogame.mappers;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import com.masegosadev.infrastructure.rest.videogame.model.PlaformResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("platformToPlatformEntityRest")
public class NamePlatformToPlatformResponse implements Function<String, PlaformResponse> {


    @Override
    public PlaformResponse apply(String namePlatform) {
        // TODO
        return new PlaformResponse();/*new PlatformEntity(platform.getName() + "::PLATFORM", platform.getName(), platform.getImageUrl())*/
    }
}
