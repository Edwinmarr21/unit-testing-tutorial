package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.handler;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases.TechRegistryUseCase;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto.TechRequest;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.mapper.EntryPointsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RequiredArgsConstructor
public class Handler {
    private final TechRegistryUseCase techRegistryUseCase;
    public ResponseEntity<Technology> insertTechnology(TechRequest technologyRequest){
        Technology technology = EntryPointsMapper.techRequestToTechnology(technologyRequest);
        Optional<Technology> technologyInserted = techRegistryUseCase.saveTechnology(technology);
        return technologyInserted.map(value -> new ResponseEntity<>(value, HttpStatusCode.valueOf(201)))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatusCode.valueOf(400)));
    }
}
