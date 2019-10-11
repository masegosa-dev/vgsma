package com.masegosadev.usecase.platform;

import org.junit.Test;
import platform.Platform;
import platform.PlatformRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CreatePlatformTest {

    private PlatformRepository platformRepository = mock(PlatformRepository.class);
    private CreatePlatform createPlatform = new CreatePlatform(platformRepository);

    @Test
    public void given_A_Platform_When_The_Create_Use_Case_Is_Executed_Then_The_Created_Platform_Should_Be_Returned(){
        //given
        Platform platform = new Platform("Ps4", "https//my_ps4_image.com");
        CreatePlatformParam createPlatformParam = new CreatePlatformParam(platform);
        given(platformRepository.createPlatform(platform)).willReturn(platform);

        //when
        Platform createdPlatform = createPlatform.execute(createPlatformParam);

        //then
        assertNotNull(createdPlatform);
        assertEquals("Ps4", createdPlatform.getName());
        assertEquals("https//my_ps4_image.com", createdPlatform.getImageUrl());
    }
}