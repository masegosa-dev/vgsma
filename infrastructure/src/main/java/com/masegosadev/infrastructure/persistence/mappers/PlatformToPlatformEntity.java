package com.masegosadev.infrastructure.persistence.mappers;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;

import java.util.function.Function;

public class PlatformToPlatformEntity implements Function<Platform, PlatformEntity> {


    @Override
    public PlatformEntity apply(Platform platform) {
        return new PlatformEntity(platform.getName() + "::PLATFORM", platform.getName(), platform.getImageUrl());
    }
}