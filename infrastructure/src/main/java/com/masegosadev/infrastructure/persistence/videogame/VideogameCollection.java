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
        return returnVideoGame(saveVideoGame(videogame));
    }

    private VideogameEntity saveVideoGame(Videogame videogame) {
        VideogameEntity videogameEntity = new VideogameEntity(videogame.getName() + "::VIDEOGAME", videogame.getName(), videogame.getImageUrl(), getPlatforms(videogame.getPlatforms()));
        return inMemoryVideogameRepository.save(videogameEntity);
    }

    private Videogame returnVideoGame(VideogameEntity videogameEntity) {
        return new Videogame(videogameEntity.getVideoGameName(), videogameEntity.getImageUrl(), getNamePlatforms(videogameEntity.getPlatformEntities()));
    }

    private Set<PlatformEntity> getPlatforms(Set<String> platformsName) {
        return platformsName.stream().map(namePlatformToPlatformEntity).collect(Collectors.toSet());
    }

    private Set<String> getNamePlatforms(Set<PlatformEntity> platforms) {
        return platforms.stream().map(platformEntityToNamePlatform).collect(Collectors.toSet());
    }
}
