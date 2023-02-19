package org.sid.serviceclient.config;

import org.sid.serviceclient.services.ClientParticulierImpl;
import org.sid.serviceclient.services.ClientProfessionnelServiceImpl;
import org.sid.serviceclient.services.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="org.sid.serviceclient.repositories")
public class jpaConfig {
    @Bean("ClientServiceImpl")
    public ClientServiceImpl clientService(){
        return new ClientServiceImpl();
    }
    @Bean("ClientParticulierImpl")
    public ClientParticulierImpl clientParticulierService(){
    return new ClientParticulierImpl();
    }
    @Bean("ClientProfessionnelServiceImpl")
    public ClientProfessionnelServiceImpl ClientProfessionnelService(){
        return new ClientProfessionnelServiceImpl();
    }
}
