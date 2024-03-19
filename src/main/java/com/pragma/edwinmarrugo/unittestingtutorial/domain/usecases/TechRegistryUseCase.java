package com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;

import java.util.Optional;

public interface TechRegistryUseCase {

    Optional<Technology> saveTechnology(Technology technology);

}
