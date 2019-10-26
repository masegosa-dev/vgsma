package com.masegosadev.infrastructure.model.platform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PlatformEntity {

    private String id;

    private String platformName;

    private String imageUrl;
}
