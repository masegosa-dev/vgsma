package com.masegosadev.usecase.platform;

import org.junit.Test;
import platform.Platform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreatePlatformTest {

    private CreatePlatform createPlatform = new CreatePlatform();

    @Test
    public void given_A_Platform_When_The_Create_Use_Case_Is_Executed_Then_The_Created_Platform_Should_Be_Returned(){
        //given
        Platform platform = new Platform("Ps4", "https//my_ps4_image.com");

        //when
        Platform createdPlatform = createPlatform.execute(platform);

        //then
        assertNotNull(createdPlatform);
        assertEquals("Ps4", createdPlatform.getName());
        assertEquals("https//my_ps4_image.com", createdPlatform.getImageUrl());
    }
}