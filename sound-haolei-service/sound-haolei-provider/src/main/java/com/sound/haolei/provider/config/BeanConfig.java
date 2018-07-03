package com.sound.haolei.provider.config;


import com.github.pagehelper.PageHelper;
import com.sound.haolei.provider.service.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Configuration
public class BeanConfig {

    @Bean
    public RedisClientTemplate  redisClientTemplate(){
        return new RedisClientTemplate();
    }


    @Autowired
    private RedisConfig redisConfig;

    @Bean
    public ShardedJedisPool getShardedJedisPool(){

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
        List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo(redisConfig.getHost()));
        return new ShardedJedisPool(jedisPoolConfig, jedisShardInfos);
    }


    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties( properties );
        return pageHelper;
    }
}
