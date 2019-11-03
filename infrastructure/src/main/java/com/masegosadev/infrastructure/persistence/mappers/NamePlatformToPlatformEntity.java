package com.masegosadev.infrastructure.persistence.mappers;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.Function;

@Component
public class NamePlatformToPlatformEntity implements Function<String, PlatformEntity> {


    @Override
    public PlatformEntity apply(String platformName) {
        // TODO
        return new PlatformEntity(UUID.randomUUID().toString(),platformName,"https://any.com")/*new PlatformEntity(platform.getName() + "::PLATFORM", platform.getName(), platform.getImageUrl())*/;
    }
}
