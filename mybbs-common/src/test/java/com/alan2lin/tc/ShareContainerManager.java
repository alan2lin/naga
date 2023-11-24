package com.alan2lin.tc;

import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;

public class ShareContainerManager {

    public static final String PG_CONTAINER_KEY = "postgres_container";
    public static HashMap<String,JdbcDatabaseContainer> containerMap = new HashMap<>();

    public static JdbcDatabaseContainer getContainer(String key){
        JdbcDatabaseContainer container = containerMap.get(key);
        if(container == null){
            if(PG_CONTAINER_KEY.equals(key)){
                PostgreSQLContainer<?> pgcontainer = new PostgreSQLContainer<>("postgres:latest")
                        .withDatabaseName("integration-tests-db")
                        .withUsername("sa")
                        .withPassword("sa");

                pgcontainer.start();
                containerMap.put(key,pgcontainer);
                container = pgcontainer;
            }
        }
        return container;
    }


    // Add the following method to retrieve the container instance
    public static PostgreSQLContainer<?> getPGContainer(String key) {
        JdbcDatabaseContainer origin = getContainer(key);
        PostgreSQLContainer container = null;
        if(origin !=null && origin instanceof PostgreSQLContainer<?>){
            container = (PostgreSQLContainer) origin;
        }
        return container;
    }
    public static PostgreSQLContainer<?> getPGContainer() {
      return getPGContainer(PG_CONTAINER_KEY);
    }
}

