package com.masegosadev.infrastructure.model.platform;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class PlatformEntity {

    private String id;

    private String platformName;

    private String imageUrl;
}
