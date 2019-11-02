package com.masegosadev.usecase.platform;

import com.masegosadev.usecase.UseCaseParams;
import com.masegosadev.domain.platform.Platform;

import java.util.Objects;

public final class CreatePlatformParam implements UseCaseParams {

    private Platform platform;

    public CreatePlatformParam(Platform platform) {
        this.platform = platform;
    }

    public Platform getPlatform() {
        return platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePlatformParam that = (CreatePlatformParam) o;
        return Objects.equals(platform, that.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platform);
    }

    @Override
    public String toString() {
        return "CreatePlatformParam{" +
                "platform=" + platform +
                '}';
    }
}
