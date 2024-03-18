package com.pragma.edwinmarrugo.unittestingtutorial.domain.ports;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;

import java.util.Optional;

public interface TechPersistencePort {
    Optional<Technology> insertTechnology(Technology eq);
}
