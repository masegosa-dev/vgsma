package com.masegosadev.usecase.platform;

import com.masegosadev.usecase.UseCase;
import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;

public final class CreatePlatform implements UseCase<CreatePlatformParam, Platform> {

    private final PlatformRepository platformRepository;

    public CreatePlatform(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public Platform execute(CreatePlatformParam createPlatformParam) {
        return platformRepository.createPlatform(createPlatformParam.getPlatform());
    }
}
