package org.jjhome.dubboplay;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class DubboBaseConfig {

    @Value("${dubbo.registry.url}")
    private String dubboRegistryUrl;

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboRegistryUrl);
        return registryConfig;
    }

    @Bean
    public ApplicationConfig applicationConfig(@Value("${app.name}") String appName) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(appName);
        return applicationConfig;
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig mc = new MonitorConfig();
        mc.setProtocol("registry");
        return mc;
    }


}

