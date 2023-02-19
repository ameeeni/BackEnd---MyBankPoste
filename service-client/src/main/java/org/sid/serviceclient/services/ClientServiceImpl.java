package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client;
import org.sid.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ClientServiceImpl{
    @Autowired
    ClientRepository clientRepository;
    @Transactional

    public Client saveClient(Client newClient) {
        return clientRepository.save(newClient);
    }

    @Transactional

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
    @Transactional


    public Client updateClient(Long id, Client updatedClient) {
     Client oldClient = clientRepository.findById(id)
              .orElseThrow(()-> new ResourceNotFoundException("Client with id: "+ id+ " does not exist"));
      oldClient.setNom(updatedClient.getNom());
      oldClient.setPrénom(updatedClient.getPrénom());
      oldClient.setPrénom(updatedClient.getEmail());
        return oldClient;
    }
    @Transactional

    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }
}
