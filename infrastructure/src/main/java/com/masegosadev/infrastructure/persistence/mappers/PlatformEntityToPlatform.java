package com.masegosadev.infrastructure.persistence.mappers;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;

import java.util.function.Function;

public class PlatformEntityToPlatform implements Function<PlatformEntity, Platform> {


    @Override
    public Platform apply(PlatformEntity platformEntity) {
        return new Platform(platformEntity.getPlatformName(), platformEntity.getImageUrl());
    }
}
