package com.masegosadev.infrastructure.rest.platform.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CreatePlatformRequest {

    private String name;
    private String imageUrl;
}
