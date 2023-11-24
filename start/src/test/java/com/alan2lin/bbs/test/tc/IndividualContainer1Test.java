package com.alan2lin.bbs.test.tc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;


/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
//@RunWith(SpringRunner.class)

@SpringBootTest
@Slf4j
@ContextConfiguration(initializers = {IndividualContainer1Test.Initializer.class})
public class IndividualContainer1Test {

    @Value("${spring.datasource.url}")
    String jdbcurl;


    @Container
    static PostgreSQLContainer<?> pgContainer = new PostgreSQLContainer<>(
            "postgres:16.1"
    ).withDatabaseName("individual-tests-db1")
            .withUsername("sa")
            .withPassword("sa");
    {
        pgContainer.start();
    }

    @Test
    void test1() {
        // Access the container directly through the parameter
        log.info("Running test 1 pgcontain jdbcurl [{}]",pgContainer.getJdbcUrl());
        log.info("Running test 1 config jdbcurl [{}]",jdbcurl);
        Assertions.assertEquals(pgContainer.getJdbcUrl(),jdbcurl);
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



}
