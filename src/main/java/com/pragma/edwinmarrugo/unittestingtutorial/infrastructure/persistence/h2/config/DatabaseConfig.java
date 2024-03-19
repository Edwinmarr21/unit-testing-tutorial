package com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.repositories")
@EntityScan(basePackages = "com.pragma.edwinmarrugo.unittestingtutorial.infrastructure.persistence.h2.entities")
public class DatabaseConfig {
}
