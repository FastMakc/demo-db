package com.example.demo.controller;

import com.example.demo.model.Pollution;
import com.example.demo.repositories.PollutionRepository;
import lombok.extern.slf4j.Slf4j;
import org.example.model.remote.RemoteResponsePollution;
import org.example.model.user.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class PollutionControllerImpl implements PollutionController {

    @Autowired PollutionRepository pollutionRepository;

    @Override
    @PostMapping(value = "/getPollution", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pollution getPollution(@RequestBody UserRequest request) {

        log.info("Id: "+ request.getLat()+"_"+request.getLon());

        return pollutionRepository.findById(request.getLat()+"_"+request.getLon()).orElse(null);


    }

    @Override
    @PostMapping(value = "/savePollution", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> savePollution(@RequestBody Pollution pollution) {

        pollutionRepository.save(pollution);
        return Mono.just(true);
    }
}
