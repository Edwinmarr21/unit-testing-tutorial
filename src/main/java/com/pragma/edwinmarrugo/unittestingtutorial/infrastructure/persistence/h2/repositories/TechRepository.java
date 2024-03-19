package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.repositories;

import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.entities.TechEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechRepository extends JpaRepository<TechEntity, String> {
}
