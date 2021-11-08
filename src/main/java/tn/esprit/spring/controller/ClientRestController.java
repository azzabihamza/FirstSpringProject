package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.DAO.Client;
import tn.esprit.spring.service.ClientService;

import java.util.List;

@RestController
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @GetMapping("getAllClients")
    public List<Client> getClients(){
        return clientService.retrieveAllClients();
    }

    @GetMapping("getClient/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") long id){
        return clientService.retrieveClient(id);
    }
}
