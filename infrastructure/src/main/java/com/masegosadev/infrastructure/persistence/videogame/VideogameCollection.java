package com.masegosadev.infrastructure.persistence.videogame;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import com.masegosadev.infrastructure.persistence.mappers.NamePlatformToPlatformEntity;
import com.masegosadev.infrastructure.persistence.mappers.PlatformEntityToNamePlatform;
import com.masegosadev.infrastructure.persistence.videogame.model.VideogameEntity;
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
        VideogameEntity videogameSaved = saveVideoGame(videogame);
        return returnVideoGame(videogameSaved);
    }

    private VideogameEntity saveVideoGame(Videogame videogame) {
        Set<PlatformEntity> platformEntities = getPlatforms(videogame.getPlatforms());
        VideogameEntity videogameEntity = new VideogameEntity(videogame.getName() + "::VIDEOGAME", videogame.getName(), videogame.getImageUrl(), platformEntities);
        return inMemoryVideogameRepository.save(videogameEntity);
    }

    private Videogame returnVideoGame(VideogameEntity videogameEntity) {
        Set<String> platforms = getNamePlatforms(videogameEntity.getPlatformEntities());
        return new Videogame(videogameEntity.getVideoGameName(), videogameEntity.getImageUrl(), platforms);
    }

    private Set<PlatformEntity> getPlatforms(Set<String> platformsName) {
        return platformsName.stream().map(namePlatformToPlatformEntity).collect(Collectors.toSet());
    }

    private Set<String> getNamePlatforms(Set<PlatformEntity> platforms) {
        return platforms.stream().map(platformEntityToNamePlatform).collect(Collectors.toSet());
    }
}
