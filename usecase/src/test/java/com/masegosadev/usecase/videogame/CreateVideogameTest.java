package com.masegosadev.usecase.videogame;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.domain.videogame.VideogameRepository;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class CreateVideogameTest {

    private VideogameRepository videogameRepository = mock(VideogameRepository.class);
    private CreateVideogame createVideogame = new CreateVideogame(videogameRepository);

    @Test
    public void given_A_Videogame_When_The_Create_Use_Case_Is_Executed_Then_The_Created_VideoGame_Should_Be_Returned() {
        //given
        Set<String> platforms = new HashSet<>();
        platforms.add("PS4");
        Videogame videogame = new Videogame("COD", "https//my_cod_image.com", platforms);
        CreateVideogameParam createVideogameParam = new CreateVideogameParam(videogame);
        given(videogameRepository.createVideogame(videogame)).willReturn(videogame);

        //when
        Videogame createdVideogame = createVideogame.execute(createVideogameParam);

        //then
        assertNotNull(createdVideogame);
        assertEquals("COD", createdVideogame.getName());
        assertEquals("https//my_cod_image.com", createdVideogame.getImageUrl());
        assertEquals(platforms, createdVideogame.getPlatforms());
    }
}
