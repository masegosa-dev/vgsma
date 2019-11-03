package com.masegosadev.boot.integration;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;
import com.masegosadev.usecase.platform.CreatePlatform;
import com.masegosadev.usecase.platform.CreatePlatformParam;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public final class CreatePlatformIT {

    @Autowired
    private PlatformRepository platformCollection;

    private CreatePlatform createPlatform;

    @Before
    public void setUp() {
        createPlatform = new CreatePlatform(platformCollection);
    }

    @Test
    public void given_A_Platform_When_The_Usecase_Is_Executed_Then_A_Platform_Is_Persisted() {
        //given
        final String name = "ps4";
        final String imageUrl = "http://ps4_logo_url";
        Platform ps4 = new Platform(name, imageUrl);
        CreatePlatformParam createPlatformParam = new CreatePlatformParam(ps4);

        //when
        Platform createdPlatform = createPlatform.execute(createPlatformParam);

        //then
        assertNotNull(createdPlatform);
        assertEquals(name, createdPlatform.getName());
        assertEquals(imageUrl, createdPlatform.getImageUrl());
    }
}
