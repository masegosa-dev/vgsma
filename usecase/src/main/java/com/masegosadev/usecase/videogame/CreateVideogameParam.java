package com.masegosadev.usecase.videogame;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.usecase.UseCaseParams;

import java.util.Objects;

public class CreateVideogameParam implements UseCaseParams {

    private Videogame videoGame;

    public CreateVideogameParam(Videogame videoGame) {
        this.videoGame = videoGame;
    }

    Videogame getVideogame() {
        return videoGame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateVideogameParam that = (CreateVideogameParam) o;
        return Objects.equals(videoGame, that.videoGame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoGame);
    }

    @Override
    public String toString() {
        return "CreateVideogameParam{" +
                "videoGame=" + videoGame +
                '}';
    }
}
