package com.masegosadev.infrastructure.persistence.videogame.model;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "videogames")
public class VideogameEntity {

    @Id
    private String id;
    private String videoGameName;
    private String imageUrl;
    private Set<PlatformEntity> platformEntities;


}
