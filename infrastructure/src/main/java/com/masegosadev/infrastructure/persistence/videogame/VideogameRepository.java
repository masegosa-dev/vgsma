package com.masegosadev.infrastructure.persistence.videogame;

import com.masegosadev.infrastructure.persistence.videogame.model.VideogameEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface VideogameRepository extends MongoRepository<VideogameEntity,String> {

}
