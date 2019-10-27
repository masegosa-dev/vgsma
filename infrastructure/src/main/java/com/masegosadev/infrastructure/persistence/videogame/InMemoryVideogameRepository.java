package com.masegosadev.infrastructure.persistence.videogame;

import com.masegosadev.infrastructure.model.videogame.VideogameEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryVideogameRepository {

    private Map<String, VideogameEntity> collection = new HashMap<>();

    VideogameEntity save(VideogameEntity videoGameEntity) {
        collection.put(videoGameEntity.getId(), videoGameEntity);
        return videoGameEntity;
    }

    public Optional<VideogameEntity> findOne(String id) {
        return Optional.ofNullable(collection.get(id));
    }

    public List<VideogameEntity> findAll() {
        return new ArrayList<>(collection.values());
    }
}
