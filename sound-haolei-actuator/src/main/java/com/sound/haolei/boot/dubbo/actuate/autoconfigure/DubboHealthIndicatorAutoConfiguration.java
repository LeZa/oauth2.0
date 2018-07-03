package com.sound.haolei.boot.dubbo.actuate.autoconfigure;

import com.sound.haolei.boot.dubbo.actuate.health.DubboHealthIndicator;
import com.sound.haolei.boot.dubbo.actuate.health.DubboHealthIndicatorProperties;
import com.sound.haolei.boot.dubbo.autoconfigure.DubboAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConditionalOnClass({HealthIndicator.class})
@AutoConfigureBefore({EndpointAutoConfiguration.class})
@AutoConfigureAfter(DubboAutoConfiguration.class)
@ConditionalOnEnabledHealthIndicator("dubbo")
@EnableConfigurationProperties(DubboHealthIndicatorProperties.class)
public class DubboHealthIndicatorAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DubboHealthIndicator dubboHealthIndicator() {
        return new DubboHealthIndicator();
    }

}
