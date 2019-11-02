package com.masegosadev.infrastructure.persistence.videogame;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import com.masegosadev.infrastructure.persistence.mappers.NamePlatformToPlatformEntity;
import com.masegosadev.infrastructure.persistence.videogame.model.VideogameEntity;
import com.masegosadev.infrastructure.persistence.mappers.PlatformEntityToNamePlatform;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class VideogameCollection implements VideogameRepository {

    private final InMemoryVideogameRepository inMemoryVideogameRepository;
    private final NamePlatformToPlatformEntity namePlatformToPlatformEntity;
    private final PlatformEntityToNamePlatform platformEntityToNamePlatform;

    public VideogameCollection(InMemoryVideogameRepository inMemoryVideogameRepository, NamePlatformToPlatformEntity namePlatformToPlatformEntity, PlatformEntityToNamePlatform platformEntityToNamePlatform) {
        this.inMemoryVideogameRepository = inMemoryVideogameRepository;
        this.namePlatformToPlatformEntity = namePlatformToPlatformEntity;
        this.platformEntityToNamePlatform = platformEntityToNamePlatform;
    }

    @Override
    public Videogame createVideogame(Videogame videogame) {
        Set<PlatformEntity> platformEntities = videogame.getPlatforms().stream().map(namePlatformToPlatformEntity).collect(Collectors.toSet());
        VideogameEntity videoGameEntity = new VideogameEntity(videogame.getName() + "::VIDEOGAME", videogame.getName(), videogame.getImageUrl(), platformEntities);
        VideogameEntity savedVideogame = inMemoryVideogameRepository.save(videoGameEntity);
        Set<String> platforms = savedVideogame.getPlatformEntities().stream().map(platformEntityToNamePlatform).collect(Collectors.toSet());

        return new Videogame(savedVideogame.getVideoGameName(), savedVideogame.getImageUrl(), platforms);
    }
}
