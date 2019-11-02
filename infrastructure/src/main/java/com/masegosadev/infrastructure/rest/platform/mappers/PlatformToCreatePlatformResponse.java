package com.masegosadev.infrastructure.rest.platform.mappers;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.rest.platform.response.CreatePlatformResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public final class PlatformToCreatePlatformResponse implements Function<Platform, CreatePlatformResponse> {

    @Override
    public CreatePlatformResponse apply(Platform platform) {
        return new CreatePlatformResponse(platform.getName(), platform.getImageUrl());
    }
}
