package com.masegosadev.infrastructure.rest.params;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class CreatePlatformParam {

    private String name;
    private String imageUrl;
}
