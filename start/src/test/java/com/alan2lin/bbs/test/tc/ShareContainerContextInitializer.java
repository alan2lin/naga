package com.alan2lin.bbs.test.tc;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class ShareContainerContextInitializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        PostgreSQLContainer<?> pgContainer = ShareContainerManager.getPGContainer();
        TestPropertyValues.of(
                "spring.datasource.url=" + pgContainer.getJdbcUrl(),
                "spring.datasource.username=" + pgContainer.getUsername(),
                "spring.datasource.password=" + pgContainer.getPassword()
        ).applyTo(configurableApplicationContext.getEnvironment());
    }
}