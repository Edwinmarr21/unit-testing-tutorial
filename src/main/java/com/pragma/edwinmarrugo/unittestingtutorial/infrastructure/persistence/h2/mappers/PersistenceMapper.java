package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.mappers;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.entities.TechEntity;

public class PersistenceMapper {

    private PersistenceMapper(){}

    public static TechEntity technologyToTechEntity(Technology technology){
        return TechEntity.builder()
                .id(technology.getId())
                .name(technology.getName())
                .description(technology.getDescription())
                .build();
    }
    public static Technology techEntityToTechnology(TechEntity technologyEntity){
        return Technology.builder()
                .id(technologyEntity.getId())
                .name(technologyEntity.getName())
                .description(technologyEntity.getDescription())
                .build();
    }

}
