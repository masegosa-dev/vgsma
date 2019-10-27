package com.masegosadev.infrastructure.persistence.videogame;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import com.masegosadev.infrastructure.model.videogame.VideogameEntity;
import com.masegosadev.infrastructure.persistence.mappers.PlatformEntityToPlatform;
import com.masegosadev.infrastructure.persistence.mappers.PlatformToPlatformEntity;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class VideogameCollection implements VideogameRepository {

    private final InMemoryVideogameRepository inMemoryVideogameRepository;
    private final PlatformToPlatformEntity platformToPlatformEntity;
    private final PlatformEntityToPlatform platformEntityToPlatform;

    public VideogameCollection(InMemoryVideogameRepository inMemoryVideogameRepository, PlatformToPlatformEntity platformToPlatformEntity, PlatformEntityToPlatform platformEntityToPlatform) {
        this.inMemoryVideogameRepository = inMemoryVideogameRepository;
        this.platformToPlatformEntity = platformToPlatformEntity;
        this.platformEntityToPlatform = platformEntityToPlatform;
    }

    @Override
    public Videogame createVideogame(Videogame videogame) {
        Set<PlatformEntity> platformEntities = videogame.getPlatforms().stream().map(platformToPlatformEntity).collect(Collectors.toSet());
        VideogameEntity videoGameEntity = new VideogameEntity(videogame.getName() + "::VIDEOGAME", videogame.getName(), videogame.getImageUrl(), platformEntities);
        VideogameEntity savedVideogame = inMemoryVideogameRepository.save(videoGameEntity);
        Set<Platform> platforms = savedVideogame.getPlatformEntities().stream().map(platformEntityToPlatform).collect(Collectors.toSet());

        return new Videogame(savedVideogame.getVideoGameName(), savedVideogame.getImageUrl(), platforms);
    }
}
