package com.sound.haolei.boot.dubbo.autoconfigure;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.LinkedHashSet;
import java.util.Set;

import static com.sound.haolei.boot.dubbo.util.DubboUtils.DUBBO_SCAN_PREFIX;

@ConfigurationProperties(prefix = DUBBO_SCAN_PREFIX)
public class DubboScanProperties {

    /**
     * The basePackages to scan , the multiple-value is delimited by comma
     *
     * @see EnableDubbo#scanBasePackages()
     */
    private Set<String> basePackages = new LinkedHashSet<>();

    public Set<String> getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(Set<String> basePackages) {
        this.basePackages = basePackages;
    }

}
