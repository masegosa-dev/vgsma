package com.masegosadev.infrastructure.model.platform;

import java.util.Objects;

public final class PlatformEntity {

    private String id;

    private String platformName;

    private String imageUrl;

    public PlatformEntity(String id, String platformName, String imageUrl) {
        this.id = id;
        this.platformName = platformName;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getPlatformName() {
        return platformName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatformEntity that = (PlatformEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(platformName, that.platformName) &&
                Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, platformName, imageUrl);
    }

    @Override
    public String toString() {
        return "PlatformEntity{" +
                "id='" + id + '\'' +
                ", platformName='" + platformName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
