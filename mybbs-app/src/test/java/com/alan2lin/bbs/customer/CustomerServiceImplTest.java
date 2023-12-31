package com.alan2lin.bbs.customer;

import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@Testcontainers
@ContextConfiguration(initializers = {CustomerServiceImplTest.Initializer.class})
@Slf4j
class CustomerServiceImplTest {


    @Value("${spring.datasource.url}")
    String jdbcurl;

    @Container
    static PostgreSQLContainer<?> pgContainer = new PostgreSQLContainer<>(
            "postgres:16.1"
    ).withDatabaseName("individual-tests-db")
            .withUsername("sa")
            .withPassword("sa");;
    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", pgContainer::getJdbcUrl);
    }

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + pgContainer.getJdbcUrl(),
                    "spring.datasource.username=" + pgContainer.getUsername(),
                    "spring.datasource.password=" + pgContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }

    @Test
    public  void mytest1(){
        log.info(" mytest1 jdbc url [{}] ",jdbcurl);
    }

}