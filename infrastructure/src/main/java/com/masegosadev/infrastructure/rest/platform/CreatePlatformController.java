package com.masegosadev.infrastructure.rest.platform;

import com.masegosadev.domain.platform.Platform;
import com.masegosadev.infrastructure.rest.platform.mappers.CreatePlatformRequestToCreatePlatformParams;
import com.masegosadev.infrastructure.rest.platform.mappers.PlatformToCreatePlatformResponse;
import com.masegosadev.infrastructure.rest.platform.request.CreatePlatformRequest;
import com.masegosadev.infrastructure.rest.platform.response.CreatePlatformResponse;
import com.masegosadev.usecase.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class CreatePlatformController {

    @Autowired
    private UseCase<com.masegosadev.usecase.platform.CreatePlatformParam, Platform> createPlatformUseCase;

    @Autowired
    private CreatePlatformRequestToCreatePlatformParams requestToParamMapper;

    @Autowired
    private PlatformToCreatePlatformResponse platformToResponseMapper;

    @PostMapping("/api/v1/platform")
    public ResponseEntity<CreatePlatformResponse> createPlatform(@RequestBody CreatePlatformRequest createPlatformRequest) {
        return created(createPlatformRequest);
    }

    public ResponseEntity<CreatePlatformResponse> created(CreatePlatformRequest createPlatformRequest) {
        Platform createdPlatform = createPlatformUseCase.execute(requestToParamMapper.apply(createPlatformRequest));
        return new ResponseEntity<>(platformToResponseMapper.apply(createdPlatform), HttpStatus.CREATED);
    }
}
