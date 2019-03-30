package org.jjhome.dubboplay;

import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.spring.ReferenceBean;
import org.jjhome.dubboplay.api.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReferServiceConfig extends DubboBaseConfig {

    @Value("${dubbo.consumer.timeout}")
    private int timeout;

    @Value("${dubbo.consumer.retries}")
    private int retries;

    @Value("${dubbo.consumer.dep.check}")
    private String check;

    @Value("${dubbo.consumer.ref.version}")
    private String dubboVersion;

    @Bean
    public ReferenceConfig referenceConfig() {
        ReferenceConfig rc = new ReferenceConfig();
        rc.setMonitor(monitorConfig());
        return rc;
    }

    @Bean
    public ReferenceBean<GreetingService> greetingService() {
        ReferenceBean<GreetingService> ref = new ReferenceBean<>();
        ref.setUrl("dubbo://localhost:20880");
        ref.setInterface(GreetingService.class);
        ref.setVersion(dubboVersion);
        ref.setTimeout(timeout);
        ref.setCheck(Boolean.parseBoolean(check));
        ref.setRetries(retries);
        return ref;
    }

}

