package com.masegosadev.infrastructure.rest.platform.mappers;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.rest.platform.request.CreatePlatformRequest;
import com.masegosadev.usecase.platform.CreatePlatformParam;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public final class CreatePlatformRequestToCreatePlatformParams implements Function<CreatePlatformRequest, CreatePlatformParam> {

    @Override
    public CreatePlatformParam apply(CreatePlatformRequest createPlatformRequest) {
        return new CreatePlatformParam(new Platform(createPlatformRequest.getName(), createPlatformRequest.getImageUrl()));
    }
}
