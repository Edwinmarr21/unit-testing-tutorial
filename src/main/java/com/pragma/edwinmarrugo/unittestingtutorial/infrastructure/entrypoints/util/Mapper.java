package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.util;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto.TechRequest;

public class Mapper {
    private Mapper(){}

    public static Technology TechRequestToTechnology(TechRequest techRequest){
        return Technology.builder()
                .id(techRequest.getId())
                .name(techRequest.getName())
                .description(techRequest.getDescription())
                .build();
    }
}
