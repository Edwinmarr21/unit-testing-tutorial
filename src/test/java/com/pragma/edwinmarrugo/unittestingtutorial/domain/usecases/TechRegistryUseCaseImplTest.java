package com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.ports.TechPersistencePort;
import com.pragma.edwinmarrugo.unittestingtutorial.testdata.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TechRegistryUseCaseImplTest {

    @Mock
    private TechPersistencePort techPersistencePort;
    @InjectMocks
    private TechRegistryUseCaseImpl techRegistryUseCase;

    @Test
    @DisplayName("Deberia insertar una tecnologia en la base de datos correctamente")
    void itShouldInsertATechnologyInTheDatabaseCorrectly() {
        //GIVEN
        Technology technology = TestData.getTechnology();
        given(techPersistencePort.insertTechnology(technology)).willReturn(Optional.of(technology));
        //WHEN
        Optional<Technology> result = techRegistryUseCase.saveTechnology(technology);
        //THEN
        assertThat(result).isPresent().contains(technology);
    }
    @Test
    @DisplayName("Deberia retornar null al insertar una tecnologia en la base de datos con fallos")
    void itShouldReturnNullWhenInsertingATechnologyInTheDatabaseWithFailure() {
        //GIVEN
        Technology technology = TestData.getTechnology();
        given(techPersistencePort.insertTechnology(technology)).willReturn(Optional.empty());
        //WHEN
        Optional<Technology> result = techRegistryUseCase.saveTechnology(technology);
        //THEN
        assertThat(result).isEmpty();
    }
}