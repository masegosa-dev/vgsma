package com.masegosadev.infrastructure.model.videogame;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideogameEntity {

    String id;
    String videoGameName;
    String imageUrl;
    Set<PlatformEntity> platformEntities;


}
