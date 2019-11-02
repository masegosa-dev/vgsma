package com.masegosadev.infrastructure.persistence.mappers;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class NamePlatformToPlatformEntity implements Function<String, PlatformEntity> {


    @Override
    public PlatformEntity apply(String namePlatforms) {
        // TODO
        return new PlatformEntity()/*new PlatformEntity(platform.getName() + "::PLATFORM", platform.getName(), platform.getImageUrl())*/;
    }
}
