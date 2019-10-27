package com.masegosadev.infrastructure.model.videogame;

import com.masegosadev.infrastructure.model.platform.PlatformEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class VideoGameRequest {

    String name;
    String imageUrl;
    Set<String> platform;
}
