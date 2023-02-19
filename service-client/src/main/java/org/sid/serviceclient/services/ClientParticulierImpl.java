package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client_Particulier;
import org.sid.serviceclient.repositories.ClientParticulierRepository;
import org.sid.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientParticulierImpl  {

  ClientParticulierRepository clientParticulierRepository;

    public Client_Particulier saveClient(Client_Particulier newClient) {
        return clientParticulierRepository.save(newClient);
    }


    public void deleteClient(Long id) {
        clientParticulierRepository.deleteById(id);
    }


    public Client_Particulier updateClient(Long id, Client_Particulier updatedClient) {
        Client_Particulier oldClient = clientParticulierRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Client with id: "+ id+ " does not exist"));
        oldClient.setNom(updatedClient.getNom());
        oldClient.setPrénom(updatedClient.getPrénom());
        oldClient.setEmail(updatedClient.getEmail());
        oldClient.setCIN(updatedClient.getCIN());
        oldClient.setDate_de_naissance(updatedClient.getDate_de_naissance());
        oldClient.setLieu_de_naissance(updatedClient.getLieu_de_naissance());
        oldClient.setProfession(updatedClient.getProfession());
        oldClient.setStatus(updatedClient.getStatus());

        return oldClient;
    }


    public Client_Particulier getClientById(Long id) {
        return  clientParticulierRepository.findById(id).get();
    }
}
