package com.masegosadev.usecase.platform;

import com.masegosadev.usecase.UseCase;
import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;

public final class CreatePlatform implements UseCase<CreatePlatformParam, Platform> {

    private final PlatformRepository platformCollection;

    public CreatePlatform(PlatformRepository platformCollection) {
        this.platformCollection = platformCollection;
    }

    @Override
    public Platform execute(CreatePlatformParam createPlatformParam) {
        return platformCollection.createPlatform(createPlatformParam.getPlatform());
    }
}
