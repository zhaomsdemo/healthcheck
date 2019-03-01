package com.zjh.healthcheck.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
//@Slf4j
public class HealthCheckConfiguration /*implements HealthIndicator*/ {

//    @Autowired
    private RestTemplate restTemplate;

//    @Override
    public Health health() {
        String url = "http://localhost:8380/configserver/actuator/health";
        try {
            restTemplate.getForObject(url,String.class);
            return Health.up().build();
        }catch (Exception e){
            return Health.down().build();
        }

    }
}
