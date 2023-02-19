package org.sid.serviceclient;

import org.sid.serviceclient.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ServiceClientApplication{


    public static void main(String[] args) {
        SpringApplication.run(ServiceClientApplication.class, args);}
  /*ndLineRunner commandLineRunner () {
        return args -> {
            Stream.of("Eya", "Mayssa", "Firas").forEach(name -> {
                Client client = new Client();
                client.setNom(name);
                client.setEmail(name + "@gmail.com");
                client.setPrénom("*****");
                client.setMot_de_passe("******");
                clientService.saveClient(client);
            });
        };*/

    }





