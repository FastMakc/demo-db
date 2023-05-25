package com.example.demo.controller;

import com.example.demo.model.Pollution;
import org.example.model.remote.RemoteResponsePollution;
import org.example.model.user.UserRequest;
import reactor.core.publisher.Mono;

public interface PollutionController {

    public Pollution getPollution(UserRequest request);

    public Mono<Boolean> savePollution(Pollution pollution);
}
