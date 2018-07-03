package com.sound.haolei.boot.dubbo.actuate.health;

import com.alibaba.dubbo.common.status.StatusChecker;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.sound.haolei.boot.dubbo.actuate.health.DubboHealthIndicatorProperties.PREFIX;


@ConfigurationProperties(prefix = PREFIX, ignoreUnknownFields = false)
public class DubboHealthIndicatorProperties {

    public static final String PREFIX = "management.health.dubbo";

    private Status status = new Status();

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static class Status {

        private Set<String> defaults = new LinkedHashSet<>(Arrays.asList("memory", "load"));

        /**
         * The extra names of {@link StatusChecker}
         */
        private Set<String> extras = new LinkedHashSet<>();

        public Set<String> getDefaults() {
            return defaults;
        }

        public void setDefaults(Set<String> defaults) {
            this.defaults = defaults;
        }

        public Set<String> getExtras() {
            return extras;
        }

        public void setExtras(Set<String> extras) {
            this.extras = extras;
        }
    }

}
