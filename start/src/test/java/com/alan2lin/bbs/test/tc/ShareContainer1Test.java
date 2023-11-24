package com.alan2lin.bbs.test.tc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;


/**
 * This is for integration test.
 *
 * Created by fulan.zjf on 2017/11/29.
 */
//@RunWith(SpringRunner.class)
@ExtendWith(ShareContainerParamterResolver.class)
@SpringBootTest
@Slf4j
@ContextConfiguration(initializers = {ShareContainerContextInitializer.class})
public class ShareContainer1Test {

    @Value("${spring.datasource.url}")
    String jdbcurl;
    @Test
    void test1(PostgreSQLContainer<?> postgresContainer) {
        // Access the container directly through the parameter
        log.info("Running test 1 jdbcurl [{}]",postgresContainer.getJdbcUrl());
        log.info("Running test 1 config jdbcurl [{}]",jdbcurl);
        Assertions.assertEquals(postgresContainer.getJdbcUrl(),jdbcurl);
    }

    @Test
    void test2(ExtensionContext context) {
        // Access the container using the TestContainerManager
        PostgreSQLContainer<?> container = ShareContainerManager.getPGContainer(ShareContainerManager.PG_CONTAINER_KEY);
        log.info("Running test 2 with container: " + container.getJdbcUrl());
        log.info("Running test 2 config jdbcurl [{}]",jdbcurl);
        Assertions.assertEquals(container.getJdbcUrl(),jdbcurl);
    }

}
