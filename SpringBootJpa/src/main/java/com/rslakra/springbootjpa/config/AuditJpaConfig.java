package com.rslakra.springbootjpa.config;

import com.rslakra.springbootjpa.service.security.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:46:59
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class AuditJpaConfig {

    /**
     * @return
     */
    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }
}
