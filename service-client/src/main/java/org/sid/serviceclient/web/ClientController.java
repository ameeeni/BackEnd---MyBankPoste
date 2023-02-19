package org.sid.serviceclient.web;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.services.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableJpaRepositories
@Component
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientServiceImpl clientService;
    @PostMapping

    public ResponseEntity<Client> saveClient(@RequestBody Client client) {
        client = clientService.saveClient(client);
        return new ResponseEntity<>(client,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client updatedClient , @PathVariable Long id){
        Client Clientupdated = clientService.updateClient(id, updatedClient);
        return  new ResponseEntity<>(Clientupdated,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient( @PathVariable Long id){
     Client   clientById = clientService.getClientById(id);
        return  new ResponseEntity<>(clientById,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }





}
