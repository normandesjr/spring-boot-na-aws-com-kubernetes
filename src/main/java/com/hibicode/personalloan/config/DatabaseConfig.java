package com.hibicode.personalloan.config;

import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.HashMap;

@Profile("production")
@Configuration
public class DatabaseConfig {

    private static final String SECRET_NAME = "personal-loan-secret";

    @Bean
    public AWSSecretsManager secretsManager() {
        return AWSSecretsManagerClientBuilder.standard().build();
    }

    @Bean
    public DataSource dataSource(AWSSecretsManager secretsManager, DataSourceProperties dataSourceProperties) throws Exception {
        String password = getPassword(secretsManager);

        return dataSourceProperties
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .password(password)
                .build();
    }

    private String getPassword(AWSSecretsManager secretsManager) throws Exception {
        var getSecretValueRequest = new GetSecretValueRequest().withSecretId(SECRET_NAME);
        var getSecretValueResult = secretsManager.getSecretValue(getSecretValueRequest);
        String secretAsJson = getSecretValueResult.getSecretString();
        return (String) new ObjectMapper().readValue(secretAsJson, HashMap.class).get("password");
    }

}
