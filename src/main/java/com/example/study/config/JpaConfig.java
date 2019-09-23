package com.example.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
//JPA감시를 설정해주겠다.
@EnableJpaAuditing
public class JpaConfig {

}
