package com.masegosadev.infrastructure.rest.platform.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class CreatePlatformResponse {

    private String name;
    private String imageUrl;
}
