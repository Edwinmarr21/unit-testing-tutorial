package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.mapper;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto.TechRequest;

public class EntryPointsMapper {
    private EntryPointsMapper(){}

    public static Technology techRequestToTechnology(TechRequest techRequest){
        return Technology.builder()
                .id(techRequest.getId())
                .name(techRequest.getName())
                .description(techRequest.getDescription())
                .build();
    }
}
