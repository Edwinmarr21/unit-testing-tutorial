package com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.ports.TechPersistencePort;
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
        Technology technology = Technology.builder()
                .id("TC0001")
                .name("Spring framework")
                .description("Framework de Java")
                .build();
        given(techPersistencePort.insertTechnology(eq(technology))).willReturn(Optional.of(technology));
        //WHEN
        Optional<Technology> result = techRegistryUseCase.saveTechnology(technology);
        //THEN
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(technology);
    }
}