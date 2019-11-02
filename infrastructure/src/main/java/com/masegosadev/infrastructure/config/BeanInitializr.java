package com.masegosadev.infrastructure.config;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;
import com.masegosadev.usecase.UseCase;
import com.masegosadev.usecase.platform.CreatePlatform;
import com.masegosadev.usecase.platform.CreatePlatformParam;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitializr {

    @Bean
    public UseCase<CreatePlatformParam, Platform> createPlatform(PlatformRepository platformCollection) {
        return new CreatePlatform(platformCollection);
    }
}
