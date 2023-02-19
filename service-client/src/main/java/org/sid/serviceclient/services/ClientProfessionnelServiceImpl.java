package org.sid.serviceclient.services;

import org.sid.serviceclient.entities.Client_Professionnel;
import org.sid.serviceclient.repositories.ClientProfessionnelRepository;
import org.sid.serviceclient.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientProfessionnelServiceImpl  {

     ClientProfessionnelRepository clientProfessionnelRepository;
    public Client_Professionnel saveClient(Client_Professionnel newClient) {
        return clientProfessionnelRepository.save(newClient);
    }

    public void deleteClient(Long id) {
        clientProfessionnelRepository.deleteById(id);
    }

    public Client_Professionnel updateClient(Long id, Client_Professionnel updatedClient) {
        Client_Professionnel oldClient = clientProfessionnelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client with id: " + id + " does not exist"));
        oldClient.setNom(updatedClient.getNom());
        oldClient.setPrénom(updatedClient.getPrénom());
        oldClient.setEmail(updatedClient.getEmail());
        oldClient.setMatricule_fiscal(updatedClient.getMatricule_fiscal());
        oldClient.setRaison_Social(updatedClient.getRaison_Social());
        oldClient.setNum_registre_commerce(updatedClient.getNum_registre_commerce());

        return oldClient;
    }

    public Client_Professionnel getClientById(Long id) {
        return clientProfessionnelRepository.findById(id).get();
    }
}
