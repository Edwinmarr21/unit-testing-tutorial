package com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.ports.TechPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class TechRegistryUseCaseImpl implements TechRegistryUseCase{

    private final TechPersistencePort techPersistencePort;

    @Override
    public Optional<Technology> saveTechnology(Technology technology) {
        return techPersistencePort.insertTechnology(technology);
    }
}
