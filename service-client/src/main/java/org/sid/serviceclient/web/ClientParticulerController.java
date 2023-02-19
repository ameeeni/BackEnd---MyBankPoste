package org.sid.serviceclient.web;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.entities.Client_Particulier;
import org.sid.serviceclient.services.ClientParticulierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@EnableJpaRepositories
@RequestMapping("/client_Particulier")
public class ClientParticulerController {
    @Autowired
    ClientParticulierImpl clientParticulierService;
    @PostMapping

    public ResponseEntity<Client_Particulier> saveClient(@RequestBody Client_Particulier client) {
        client = clientParticulierService.saveClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client_Particulier> updateClient(@RequestBody Client_Particulier updatedClient , @PathVariable Long id){
        Client_Particulier Clientupdated = clientParticulierService.updateClient(id, updatedClient);
        return  new ResponseEntity<>(Clientupdated,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Client_Particulier> getClientById( @PathVariable Long id){
        Client_Particulier   clientById = clientParticulierService.getClientById(id);
        return  new ResponseEntity<>(clientById,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable Long id) {
        clientParticulierService.deleteClient(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
