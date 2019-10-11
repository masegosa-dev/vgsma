package com.masegosadev.usecase.platform;

import com.masegosadev.usecase.UseCase;
import platform.Platform;
import platform.PlatformRepository;

public final class CreatePlatform implements UseCase<CreatePlatformParam, Platform> {

    private PlatformRepository platformRepository;

    public CreatePlatform(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public Platform execute(CreatePlatformParam createPlatformParam) {
        return platformRepository.createPlatform(createPlatformParam.getPlatform());
    }
}
