package com.sound.haolei.boot.dubbo.actuate.autoconfigure;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.boot.dubbo.actuate.endpoint.DubboEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnClass({Service.class, Endpoint.class})
public class DubboEndpointAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DubboEndpoint dubboEndpoint() {
        return new DubboEndpoint();
    }

}
