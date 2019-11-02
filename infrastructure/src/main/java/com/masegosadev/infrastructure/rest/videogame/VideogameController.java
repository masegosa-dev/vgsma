package com.masegosadev.infrastructure.rest.videogame;

import com.masegosadev.domain.videogame.Videogame;
import com.masegosadev.infrastructure.rest.videogame.mappers.VideogameRequestToVideogame;
import com.masegosadev.infrastructure.rest.videogame.mappers.VideogameToVideogameResponse;
import com.masegosadev.infrastructure.rest.videogame.model.VideogameRequest;
import com.masegosadev.infrastructure.rest.videogame.model.VideogameResponse;
import com.masegosadev.usecase.UseCase;
import com.masegosadev.usecase.videogame.CreateVideogameParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
public class VideogameController {

    @Autowired
    private UseCase<CreateVideogameParam, Videogame> createVideogame;
    @Autowired
    private VideogameRequestToVideogame videogameRequestToVideogame;
    @Autowired
    private VideogameToVideogameResponse videogameToVideogameResponse;

    @PostMapping(value = "/createVideoGame")
    public ResponseEntity<VideogameResponse> createVideogame(@RequestBody @Valid VideogameRequest videogameRequest) {

        Videogame savedVideoGame = createVideogame.execute(new CreateVideogameParam(videogameRequestToVideogame.apply(videogameRequest)));

        return new ResponseEntity<>(videogameToVideogameResponse.apply(savedVideoGame), HttpStatus.CREATED);
    }
}
