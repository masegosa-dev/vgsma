package com.masegosadev.infrastructure.config;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.usecase.UseCase;
import com.masegosadev.usecase.videogame.CreateVideogame;
import com.masegosadev.usecase.videogame.CreateVideogameParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializer {

    @Bean
    public UseCase<CreateVideogameParam, Videogame> createVideoGame(VideogameRepository videogameRepository) {
        return new CreateVideogame(videogameRepository);
    }
}
