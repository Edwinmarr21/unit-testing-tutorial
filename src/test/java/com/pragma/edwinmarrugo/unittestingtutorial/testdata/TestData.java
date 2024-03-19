package com.pragma.edwinmarrugo.unittestingtutorial.testdata;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto.TechRequest;

public class TestData {

    public static final String TC_0001 = "TC0001";
    public static final String TECHNOLOGY_NAME = "Spring framework";
    public static final String TECHNOLOGY_DESCRIPTION = "Framework de Java";

    public static Technology getTechnology(){
        return Technology.builder()
                .id(TC_0001)
                .name(TECHNOLOGY_NAME)
                .description(TECHNOLOGY_DESCRIPTION)
                .build();
    }
    public static TechRequest getTechRequest(){
        return TechRequest.builder()
                .id(TC_0001)
                .name(TECHNOLOGY_NAME)
                .description(TECHNOLOGY_DESCRIPTION)
                .build();
    }
}
