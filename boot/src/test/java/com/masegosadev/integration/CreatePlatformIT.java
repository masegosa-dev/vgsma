package com.masegosadev.integration;

import com.masegosadev.usecase.platform.CreatePlatform;
import com.masegosadev.usecase.platform.CreatePlatformParam;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import platform.Platform;
import platform.PlatformRepository;

@RunWith(SpringRunner.class)
@Profile("test")
public final class CreatePlatformIT {

    @Autowired
    private PlatformRepository platformCollection;

    private CreatePlatform createPlatform = new CreatePlatform(platformCollection);

    @Test
    public void given_A_Platform_When_The_Usecase_Is_Executed_Then_A_Platform_Is_Persisted() {
        //given
        Platform ps4 = new Platform("ps4", "http://ps4_logo_url");
        CreatePlatformParam createPlatformParam = new CreatePlatformParam(ps4);

        //when
        Platform execute = createPlatform.execute(createPlatformParam);

        //then
        Assert.assertNotNull(execute);
    }
}
