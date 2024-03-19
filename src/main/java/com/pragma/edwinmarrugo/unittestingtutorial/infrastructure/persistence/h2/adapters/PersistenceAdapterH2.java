package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.adapters;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.model.Technology;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.ports.TechPersistencePort;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.entities.TechEntity;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.mappers.PersistenceMapper;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.repositories.TechRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

@RequiredArgsConstructor
public class PersistenceAdapterH2 implements TechPersistencePort {
    private final TechRepository techRepository;
    private static final Logger log = LoggerFactory.getLogger(PersistenceAdapterH2.class);
    @Override
    public Optional<Technology> insertTechnology(Technology technology) {
        try{
            TechEntity result = techRepository.save(PersistenceMapper.technologyToTechEntity(technology));
            Technology technologyReturned = PersistenceMapper.techEntityToTechnology(result);
            return Optional.of(technologyReturned);
        }catch (DataIntegrityViolationException e){
            log.info("Se produjo una excepcion al intentar insertar la tecnologia {}, mensaje:  {}", technology.getName(), e.getMessage());
            return Optional.empty();
        }
    }
}
