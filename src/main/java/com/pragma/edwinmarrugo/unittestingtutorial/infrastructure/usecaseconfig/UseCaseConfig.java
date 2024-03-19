package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.usecaseconfig;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.ports.TechPersistencePort;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases.TechRegistryUseCase;
import com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases.TechRegistryUseCaseImpl;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.adapters.PersistenceAdapterH2;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.repositories.TechRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UseCaseConfig {
    private final TechRepository techRepository;
    @Bean
    public TechRegistryUseCase techRegistryUseCase(){
        return new TechRegistryUseCaseImpl(techPersistencePort());
    }
    @Bean
    public TechPersistencePort techPersistencePort() {
        return new PersistenceAdapterH2(techRepository);
    }
}
