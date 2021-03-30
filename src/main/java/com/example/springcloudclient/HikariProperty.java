package com.example.springcloudclient;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Getter
@Setter
@ConfigurationProperties("hikari")
@RefreshScope
public class HikariProperty {
    private String connectionTimeout;
    private String maximumPoolSize;
    private String maxLifeTime;
    private String registerMbeans;
    private String poolName;
}
