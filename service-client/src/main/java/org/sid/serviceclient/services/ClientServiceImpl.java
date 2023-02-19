package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class ClientServiceImpl{

    ClientRepository clientRepository;
    public Client saveClient(Client newClient) {
        return clientRepository.save(newClient);
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client updateClient(Long id, Client updatedClient) {
     Client oldClient = clientRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Client with id: "+ id+ " does not exist"));
      oldClient.setNom(updatedClient.getNom());
      oldClient.setPrénom(updatedClient.getPrénom());
      oldClient.setPrénom(updatedClient.getEmail());
        return oldClient;
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }
}
