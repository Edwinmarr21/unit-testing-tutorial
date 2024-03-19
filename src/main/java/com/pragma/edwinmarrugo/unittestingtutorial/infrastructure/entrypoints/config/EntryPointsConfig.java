package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.config;

import com.pragma.edwinmarrugo.unittestingtutorial.domain.usecases.TechRegistryUseCase;
import com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.entrypoints.handler.Handler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EntryPointsConfig {
    private final TechRegistryUseCase techRegistryUseCase;
    @Bean
    public Handler handler(){
        return new Handler(techRegistryUseCase);
    }

}
