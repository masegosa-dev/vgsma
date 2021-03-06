package com.masegosadev.usecase.videogame;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.usecase.UseCase;

public final class CreateVideogame implements UseCase<CreateVideogameParam, Videogame> {

    private final VideogameRepository videoGameRepository;

    public CreateVideogame(VideogameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }

    @Override
    public Videogame execute(CreateVideogameParam createVideogameParam) {
        //TODO Pending to check if the platforms exists

        return videoGameRepository.createVideogame(createVideogameParam.getVideogame());
    }
}
