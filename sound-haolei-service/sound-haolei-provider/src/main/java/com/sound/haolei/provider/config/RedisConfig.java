package com.sound.haolei.provider.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    public  RedisConfig() { }

    @Value("${jedis.port}")
    private String port;

    @Value("${jedis.host}")
    private String host;

    @Value("${jedis.max.total}")
    private Integer maxTotal;

    @Value("${jedis.max.idle}")
    private Integer maxIdle;

    @Value("${jedis.max.waitmillis}")
    private Long maxWaitMillis;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(Long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }
}
