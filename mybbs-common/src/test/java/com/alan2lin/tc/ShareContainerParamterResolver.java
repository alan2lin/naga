package com.alan2lin.tc;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 *   to share
 */
public class ShareContainerParamterResolver implements ParameterResolver {

    public static final String CONTAINER_KEY = "postgres_container";

    @Override
    public boolean supportsParameter(
            ParameterContext parameterContext, ExtensionContext extensionContext) {
        Class<?> paramType = parameterContext.getParameter().getType();
        return paramType.equals(PostgreSQLContainer.class)|| paramType.equals(ExtensionContext.class);
    }

    @Override
    public Object resolveParameter(
            ParameterContext parameterContext, ExtensionContext extensionContext) {
        Store store = extensionContext.getStore(
                ExtensionContext.Namespace.create(getClass(), extensionContext));

        Class<?> paramType = parameterContext.getParameter().getType();
        if(paramType.equals(PostgreSQLContainer.class)){
            return ShareContainerManager.getPGContainer();

        }
        if(  paramType.equals(ExtensionContext.class)){
            return extensionContext;
        }
        return null;
    }

}

