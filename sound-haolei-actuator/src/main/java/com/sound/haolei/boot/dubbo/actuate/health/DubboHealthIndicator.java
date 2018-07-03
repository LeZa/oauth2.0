package com.sound.haolei.boot.dubbo.actuate.health;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.common.status.StatusChecker;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static com.alibaba.dubbo.common.extension.ExtensionLoader.getExtensionLoader;
import static com.sound.haolei.boot.dubbo.actuate.health.DubboHealthIndicatorProperties.PREFIX;

public class DubboHealthIndicator extends AbstractHealthIndicator {

    @Autowired
    private DubboHealthIndicatorProperties dubboHealthIndicatorProperties;

    @Autowired(required = false)
    private Map<String, ProtocolConfig> protocolConfigs = Collections.emptyMap();

    @Autowired(required = false)
    private Map<String, ProviderConfig> providerConfigs = Collections.emptyMap();

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        ExtensionLoader<StatusChecker> extensionLoader = getExtensionLoader(StatusChecker.class);
        Map<String, String> statusCheckerNamesMap = resolveStatusCheckerNamesMap();
        boolean hasError = false;
        boolean hasUnknown = false;
        // Up first
        builder.up();
        for (Map.Entry<String, String> entry : statusCheckerNamesMap.entrySet()) {
            String statusCheckerName = entry.getKey();
            String source = entry.getValue();
            StatusChecker checker = extensionLoader.getExtension(statusCheckerName);
            com.alibaba.dubbo.common.status.Status status = checker.check();
            com.alibaba.dubbo.common.status.Status.Level level = status.getLevel();
            if (!hasError && level.equals(com.alibaba.dubbo.common.status.Status.Level.ERROR)) {
                hasError = true;
                builder.down();
            }
            if (!hasError && !hasUnknown && level.equals(com.alibaba.dubbo.common.status.Status.Level.UNKNOWN)) {
                hasUnknown = true;
                builder.unknown();
            }
            Map<String, Object> detail = new LinkedHashMap<>();
            detail.put("source", source);
            detail.put("status", status);
            builder.withDetail(statusCheckerName, detail);
        }
    }

    protected Map<String, String> resolveStatusCheckerNamesMap() {

        Map<String, String> statusCheckerNamesMap = new LinkedHashMap<>();
        statusCheckerNamesMap.putAll(resolveStatusCheckerNamesMapFromDubboHealthIndicatorProperties());
        statusCheckerNamesMap.putAll(resolveStatusCheckerNamesMapFromProtocolConfigs());
        statusCheckerNamesMap.putAll(resolveStatusCheckerNamesMapFromProviderConfig());
        return statusCheckerNamesMap;

    }

    private Map<String, String> resolveStatusCheckerNamesMapFromDubboHealthIndicatorProperties() {

        DubboHealthIndicatorProperties.Status status =
                dubboHealthIndicatorProperties.getStatus();
        Map<String, String> statusCheckerNamesMap = new LinkedHashMap<>();
        for (String statusName : status.getDefaults()) {
            statusCheckerNamesMap.put(statusName, PREFIX + ".status.defaults");
        }

        for (String statusName : status.getExtras()) {
            statusCheckerNamesMap.put(statusName, PREFIX + ".status.extras");
        }
        return statusCheckerNamesMap;

    }


    private Map<String, String> resolveStatusCheckerNamesMapFromProtocolConfigs() {

        Map<String, String> statusCheckerNamesMap = new LinkedHashMap<>();
        for (Map.Entry<String, ProtocolConfig> entry : protocolConfigs.entrySet()) {
            String beanName = entry.getKey();
            ProtocolConfig protocolConfig = entry.getValue();
            Set<String> statusCheckerNames = getStatusCheckerNames(protocolConfig);
            for (String statusCheckerName : statusCheckerNames) {
                String source = buildSource(beanName, protocolConfig);
                statusCheckerNamesMap.put(statusCheckerName, source);
            }
        }
        return statusCheckerNamesMap;

    }

    private Map<String, String> resolveStatusCheckerNamesMapFromProviderConfig() {

        Map<String, String> statusCheckerNamesMap = new LinkedHashMap<>();
        for (Map.Entry<String, ProviderConfig> entry : providerConfigs.entrySet()) {
            String beanName = entry.getKey();
            ProviderConfig providerConfig = entry.getValue();
            Set<String> statusCheckerNames = getStatusCheckerNames(providerConfig);
            for (String statusCheckerName : statusCheckerNames) {
                String source = buildSource(beanName, providerConfig);
                statusCheckerNamesMap.put(statusCheckerName, source);
            }
        }
        return statusCheckerNamesMap;

    }

    private Set<String> getStatusCheckerNames(ProtocolConfig protocolConfig) {
        String status = protocolConfig.getStatus();
        return StringUtils.commaDelimitedListToSet(status);
    }

    private Set<String> getStatusCheckerNames(ProviderConfig providerConfig) {
        String status = providerConfig.getStatus();
        return StringUtils.commaDelimitedListToSet(status);
    }

    private String buildSource(String beanName, Object bean) {
        return beanName + "@" + bean.getClass().getSimpleName() + ".getStatus()";
    }

}
