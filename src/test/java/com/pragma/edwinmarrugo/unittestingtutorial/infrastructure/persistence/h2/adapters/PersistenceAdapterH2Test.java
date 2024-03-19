package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.adapters;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.entities.TechEntity;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.mappers.PersistenceMapper;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.repositories.TechRepository;
import com.pragma.edwinmarrugo.unittestingtutorial.testdata.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersistenceAdapterH2Test {

    @Mock
    private TechRepository techRepository;
    @InjectMocks
    private PersistenceAdapterH2 persistenceAdapterH2;

    public static Stream<Arguments> provideTechnologiesToInsertWithValidationErrors(){
        return Stream.of(
                Arguments.of(
                        Technology.builder()
                                .id(TestData.TC_0001)
                                .name("nombre de tecnología demasiado largo -----------------------------------------------------------")
                                .description(TestData.TECHNOLOGY_DESCRIPTION)
                                .build()),
                Arguments.of(
                        Technology.builder()
                                .id(TestData.TC_0001)
                                .name(TestData.TECHNOLOGY_NAME)
                                .description("descripcion de tecnología demasiado larga ----------------------------------------------------------------------------------------------------------------------------------------------------")
                                .build())
        );
    }

    @Test
    @DisplayName("Deberia insertar una tecnologia correctamente")
    void itShouldInsertATechnology() {
        //GIVEN
        Technology technology = TestData.getTechnology();
        TechEntity techEntity = PersistenceMapper.technologyToTechEntity(technology);
        given(techRepository.save(techEntity)).willReturn(techEntity);
        //WHEN
        Optional<Technology> result = persistenceAdapterH2.insertTechnology(technology);
        //THEN
        assertThat(result).isPresent().contains(technology);

    }

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se inserte una tecnologia con id repetido")
    void itShouldThrowAnExceptionWhenInsertingATechnologyWithRepeatedId() {
        //GIVEN
        Technology technology = TestData.getTechnology();
        TechEntity techEntity = PersistenceMapper.technologyToTechEntity(technology);
        given(techRepository.save(techEntity)).willThrow(new DataIntegrityViolationException("Ya existe una tecnologia con el id que se intento insertar"));
        //WHEN
        Optional<Technology> result = persistenceAdapterH2.insertTechnology(technology);
        //THEN
        assertThat(result).isEmpty();
    }
    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se inserte una tecnologia con nombre repetido")
    void itShouldThrowAnExceptionWhenInsertingATechnologyWithRepeatedName() {
        //GIVEN
        Technology technology = TestData.getTechnology();
        TechEntity techEntity = PersistenceMapper.technologyToTechEntity(technology);
        given(techRepository.save(techEntity)).willThrow(new DataIntegrityViolationException("Ya existe una tecnologia con el nombre que se intento insertar"));
        //WHEN
        Optional<Technology> result = persistenceAdapterH2.insertTechnology(technology);
        //THEN
        assertThat(result).isEmpty();
    }
    @ParameterizedTest
    @MethodSource("provideTechnologiesToInsertWithValidationErrors")
    @DisplayName("Deberia lanzar una excepcion cuando se inserte una tecnologia con error de validacion")
    void itShouldThrowAnExceptionWhenInsertingATechnologyWithAValidationError(Technology technology) {
        //GIVEN
        TechEntity techEntity = PersistenceMapper.technologyToTechEntity(technology);
        given(techRepository.save(techEntity)).willThrow(new DataIntegrityViolationException("Error de validacion de campos"));
        //WHEN
        Optional<Technology> result = persistenceAdapterH2.insertTechnology(technology);
        //THEN
        assertThat(result).isEmpty();
    }
}