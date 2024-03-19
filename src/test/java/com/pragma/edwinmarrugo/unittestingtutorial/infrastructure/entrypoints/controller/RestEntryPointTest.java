package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.controller;

import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.dto.TechRequest;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.handler.Handler;
import com.pragma.edwinmarrugo.unittestingtutorial.testdata.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class RestEntryPointTest {

    @Mock
    private Handler handler;
    @InjectMocks
    private RestEntryPoint restEntryPoint;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(restEntryPoint).build();
    }

    @Test
    @DisplayName("Deberia insertar correctamente una tecnologia")
    void itShouldInsertATechnology() throws Exception {
        //GIVEN
        given(handler.insertTechnology(any(TechRequest.class)))
                .willReturn(new ResponseEntity<>(TestData.getTechnology(), HttpStatusCode.valueOf(201)));

        String body = "{\"id\":\"TC0001\",\"name\":\"Spring framework\",\"description\":\"Descripcion para spring framework\"}";

        MockHttpServletRequestBuilder request = post("/microservice_delivery/technology")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body);
        //WHEN-THEN
        mockMvc.perform(request).andExpect(status().isCreated());
    }
    @Test
    @DisplayName("Deberia manejar validacion de tamano descripcion")
    void itShouldHandleSizeDescriptionValidationError() throws Exception {
        //GIVEN
        String body = "{\"id\":\"TC0001\",\"name\":\"Spring framework\",\"description\":\"Descripcion para spring framework-------------------------------------------------------------------------------------------------\"}";

        MockHttpServletRequestBuilder request = post("/microservice_delivery/technology")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body);
        //WHEN-THEN
        mockMvc.perform(request).andExpect(status().isBadRequest());
    }
    @Test
    @DisplayName("Deberia manejar validacion de tamano nombre")
    void itShouldHandleSizeNameValidationError() throws Exception {
        //GIVEN
        String body = "{\"id\":\"TC0001\",\"name\":\"Spring framework---------------------------------------------------------------------------------\",\"description\":\"Descripcion para spring framework\"}";

        MockHttpServletRequestBuilder request = post("/microservice_delivery/technology")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body);
        //WHEN-THEN
        mockMvc.perform(request).andExpect(status().isBadRequest());
    }
}