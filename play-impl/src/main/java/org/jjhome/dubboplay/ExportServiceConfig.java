package org.jjhome.dubboplay;

import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.spring.ServiceBean;
import org.jjhome.dubboplay.api.service.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExportServiceConfig extends DubboBaseConfig {

    private static String JAVASSIST = "javassist";

    @Value("${dubbo.provider.port}")
    private Integer port;

    @Value("${dubbo.provider.version}")
    private String dubboExportVersion;

    @Value("${dubbo.provider.timeout}")
    private int timeout;

    @Value("${dubbo.provider.retries}")
    private int retries;

    @Value("${dubbo.provider.longtimeout}")
    private int longTimeout;


    @Bean
    public ProtocolConfig protocol() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(port);
        protocolConfig.setThreads(600);
        return protocolConfig;
    }

    @Bean
    public ProviderConfig provider() {
        ProviderConfig providerConfig = new ProviderConfig();
        providerConfig.setMonitor(monitorConfig());
        return providerConfig;
    }

    @Bean
    public ServiceBean<GreetingService> greetingServiceExport(GreetingService greetingService) {
        ServiceBean<GreetingService> serviceBean = new ServiceBean<>();
        serviceBean.setProxy(JAVASSIST);
        serviceBean.setVersion(dubboExportVersion);
        serviceBean.setInterface(GreetingService.class);
        serviceBean.setRef(greetingService);
        serviceBean.setTimeout(timeout);
        serviceBean.setRetries(retries);
        return serviceBean;
    }

}

