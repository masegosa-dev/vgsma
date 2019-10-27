package com.masegosadev.domain.videogame;

import com.masegosadev.domain.platform.Platform;

import java.util.Objects;
import java.util.Set;

public final class Videogame {

    private String name;
    private String imageUrl;
    private Set<Platform> platforms;

    public Videogame(String name, String imageUrl, Set<Platform> platforms) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.platforms = platforms;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Videogame videogame = (Videogame) o;
        return Objects.equals(name, videogame.name) &&
                Objects.equals(imageUrl, videogame.imageUrl) &&
                Objects.equals(platforms, videogame.platforms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageUrl, platforms);
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", platforms=" + platforms +
                '}';
    }
}
