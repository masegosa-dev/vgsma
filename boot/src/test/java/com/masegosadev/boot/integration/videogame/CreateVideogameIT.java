package com.masegosadev.boot.integration.videogame;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import com.masegosadev.usecase.videogame.CreateVideogame;
import com.masegosadev.usecase.videogame.CreateVideogameParam;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateVideogameIT {

    @Autowired
    private VideogameRepository videogameCollection;

    private CreateVideogame createVideogame;

    @Before
    public void setUp() {
        this.createVideogame = new CreateVideogame(videogameCollection);
    }

    @Test
    public void given_A_Videogame_When_The_UseCase_Is_Executed_A_Videogame_Is_Persisted() {
        //given
        Set<String> platforms = new HashSet<>();
        platforms.add("PS4");
        Videogame cod = new Videogame("COD", "http://cod_logo_url", platforms);
        CreateVideogameParam createVideogameParam = new CreateVideogameParam(cod);

        //when
        Videogame execute = createVideogame.execute(createVideogameParam);

        //then
        Assert.assertNotNull(execute);
    }
}
