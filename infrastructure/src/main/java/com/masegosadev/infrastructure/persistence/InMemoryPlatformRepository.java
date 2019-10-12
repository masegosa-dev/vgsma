package com.masegosadev.infrastructure.persistence;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public final class InMemoryPlatformRepository {

    private final Map<String, PlatformEntity> collection = new HashMap<>();

    public PlatformEntity save(PlatformEntity platformEntity) {
        collection.put(platformEntity.getId(), platformEntity);
        return platformEntity;
    }

    public Optional<PlatformEntity> findOne(String id) {
        return Optional.ofNullable(collection.get(id));
    }

    public List<PlatformEntity> findAll() {
        return new ArrayList<>(collection.values());
    }
}
