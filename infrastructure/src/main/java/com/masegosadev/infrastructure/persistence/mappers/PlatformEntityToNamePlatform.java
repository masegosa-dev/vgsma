package com.masegosadev.infrastructure.persistence.mappers;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PlatformEntityToNamePlatform implements Function<PlatformEntity, String> {


    @Override
    public String apply(PlatformEntity platformEntity) {
        return platformEntity.getPlatformName();
    }
}
