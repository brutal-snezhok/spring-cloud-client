package com.example.springcloudclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@Configuration
@EnableConfigurationProperties(HikariProperty.class)
public class Controller {

    private final HikariProperty hikariProperty;

    @Value("${env}")
    private String env;

    public Controller(HikariProperty hikariProperty) {
        this.hikariProperty = hikariProperty;
    }

    @RequestMapping("/hikari-info")
    public String showConfig() {
        String configInfo = "Hikari Configuration for env = " + env
                + "<br/>connectionTimeout= " + hikariProperty.getConnectionTimeout()
                + "<br/>maximumPoolSize= " + hikariProperty.getMaximumPoolSize()
                + "<br/>lifeTime= " + hikariProperty.getMaxLifeTime()
                + "<br/>registerMbeans= " + hikariProperty.getRegisterMbeans()
                + "<br/>poolName= " + hikariProperty.getPoolName();

        return configInfo;
    }
}
