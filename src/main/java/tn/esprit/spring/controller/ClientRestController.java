package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping(value="/updateClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client updateClient(@RequestBody Client client){
        return clientService.updateClient(client);
    }

    @PostMapping(value="/addClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @DeleteMapping(value="/deleteClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClient(@RequestBody Client client){
        clientService.deleteClient(client);
    }
}
