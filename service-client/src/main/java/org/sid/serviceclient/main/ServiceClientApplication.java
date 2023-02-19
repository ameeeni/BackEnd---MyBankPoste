package org.sid.serviceclient.main;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.services.ClientServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@SpringBootApplication()
@ComponentScan(basePackages="org.sid.serviceclient.*")
@EntityScan("org.sid.serviceclient.entities")
@EnableJpaRepositories("org.sid.serviceclient.repositories")
public class ServiceClientApplication {

ClientServiceImpl clientService;
    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);}



    @Bean
    CommandLineRunner commandLineRunner () {
        return args -> {
            Stream.of("Eya", "Mayssa", "Firas").forEach(name -> {
                Client client = new Client();
                client.setNom(name);
                client.setEmail(name + "@gmail.com");
                client.setPrénom("*****");
                client.setMot_de_passe("******");
                clientService.saveClient(client);
            });
        };

    }
}





