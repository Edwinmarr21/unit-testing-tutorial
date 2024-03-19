package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.controller;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto.TechRequest;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.handler.Handler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("microservice_delivery")
public class RestEntryPoint {
    private final Handler handler;

    public RestEntryPoint(@Autowired Handler handler) {
        this.handler = handler;
    }

    @PostMapping("technology")
    public ResponseEntity<Technology> insertTechnology(@Valid @RequestBody TechRequest technology){
        return handler.insertTechnology(technology);
    }
}
