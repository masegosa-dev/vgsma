package com.masegosadev.infrastructure.config;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;
import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.usecase.UseCase;
import com.masegosadev.usecase.platform.CreatePlatform;
import com.masegosadev.usecase.platform.CreatePlatformParam;
import com.masegosadev.usecase.videogame.CreateVideogame;
import com.masegosadev.usecase.videogame.CreateVideogameParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializr {

    @Bean
    public UseCase<CreateVideogameParam, Videogame> createVideoGame(VideogameRepository videogameRepository) {
        return new CreateVideogame(videogameRepository);
    }

    @Bean
    public UseCase<CreatePlatformParam, Platform> createPlatform(PlatformRepository platformCollection) {
        return new CreatePlatform(platformCollection);
    }
}
