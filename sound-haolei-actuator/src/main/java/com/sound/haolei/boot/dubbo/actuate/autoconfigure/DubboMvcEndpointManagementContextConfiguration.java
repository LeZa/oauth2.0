package com.sound.haolei.boot.dubbo.actuate.autoconfigure;

import com.alibaba.dubbo.config.annotation.Service;
import com.sound.haolei.boot.dubbo.actuate.endpoint.DubboEndpoint;
import com.sound.haolei.boot.dubbo.actuate.endpoint.mvc.DubboMvcEndpoint;
import org.springframework.boot.actuate.autoconfigure.ManagementContextConfiguration;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;


@ManagementContextConfiguration
@ConditionalOnClass({Service.class, EndpointMvcAdapter.class})
@ConditionalOnWebApplication
public class DubboMvcEndpointManagementContextConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DubboMvcEndpoint dubboMvcEndpoint(DubboEndpoint dubboEndpoint) {
        return new DubboMvcEndpoint(dubboEndpoint);
    }


}
