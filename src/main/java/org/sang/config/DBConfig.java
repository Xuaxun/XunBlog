package org.sang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@Component
@PropertySource(value = "classpath:jdbc.properties",encoding = "UTF-8")
public class DBConfig {
    @Value("${db.driverClass}")
    public String driver;
    @Value("${db.url}")
    public String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.initialSize}")
    private String initialSize;
    @Value("${db.maxActive}")
    private int maxActive;
    @Value("${db.maxIdle}")
    private int maxIdle;
    @Value("${db.minIdle}")
    private int minIdle;
    @Value("${db.maxWait}")
    private int maxWait;
}
