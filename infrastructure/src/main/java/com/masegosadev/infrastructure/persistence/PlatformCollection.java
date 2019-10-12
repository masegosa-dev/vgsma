package com.masegosadev.infrastructure.persistence;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import org.springframework.stereotype.Repository;

@Repository
public final class PlatformCollection implements PlatformRepository {

    private final InMemoryPlatformRepository inMemoryPlatformRepository;

    public PlatformCollection(InMemoryPlatformRepository inMemoryPlatformRepository) {
        this.inMemoryPlatformRepository = inMemoryPlatformRepository;
    }

    @Override
    public Platform createPlatform(Platform platform) {
        PlatformEntity platformEntity = new PlatformEntity(platform.getName() + "::PLATFORM", platform.getName(), platform.getImageUrl());
        PlatformEntity savedPlatform = inMemoryPlatformRepository.save(platformEntity);
        return new Platform(savedPlatform.getPlatformName(), savedPlatform.getImageUrl());
    }
}
