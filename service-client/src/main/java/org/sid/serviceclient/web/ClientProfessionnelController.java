package org.sid.serviceclient.web;


import org.sid.serviceclient.entities.Client_Professionnel;
import org.sid.serviceclient.services.ClientProfessionnelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@EnableJpaRepositories
@RequestMapping("/client_Professionel")
public class ClientProfessionnelController {
    @Autowired
    ClientProfessionnelServiceImpl clientProfessionnelService;
    @PostMapping

    public ResponseEntity<Client_Professionnel> saveClient_Professionnel(@RequestBody Client_Professionnel client) {
        client = clientProfessionnelService.saveClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client_Professionnel> updateClient_Professionnel(@RequestBody Client_Professionnel updatedClient , @PathVariable Long id){
        Client_Professionnel Clientupdated = clientProfessionnelService.updateClient(id, updatedClient);
        return  new ResponseEntity<>(Clientupdated,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Client_Professionnel> getClient_ProfessionnelById( @PathVariable Long id){
        Client_Professionnel  clientById = clientProfessionnelService.getClientById(id);
        return  new ResponseEntity<>(clientById,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Client_Professionnel> deleteClient_Particulier(@PathVariable Long id) {
        clientProfessionnelService.deleteClient(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
