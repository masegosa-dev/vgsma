package com.masegosadev.boot.integration;

import com.masegosadev.usecase.platform.CreatePlatform;
import com.masegosadev.usecase.platform.CreatePlatformParam;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.platform.PlatformRepository;

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
        Platform ps4 = new Platform("ps4", "http://ps4_logo_url");
        CreatePlatformParam createPlatformParam = new CreatePlatformParam(ps4);

        //when
        Platform execute = createPlatform.execute(createPlatformParam);

        //then
        Assert.assertNotNull(execute);
    }
}
