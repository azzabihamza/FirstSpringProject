package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.service.ClientService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @GetMapping("getAllClients")
    public List<ClientEntity> getClients(){
        return clientService.retrieveAllClients();
    }

    @GetMapping("getClient/{client-id}")
    public ClientEntity retrieveClient(@PathVariable("client-id") long id){
        return clientService.retrieveClient(id);
    }

    @PutMapping(value="/updateClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientEntity updateClient(@RequestBody ClientEntity client){
        return clientService.updateClient(client);
    }

    @PostMapping(value="/addClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ClientEntity addClient(@RequestBody ClientEntity client){
        return clientService.addClient(client);
    }

    @DeleteMapping(value="/deleteClient",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteClient(@RequestBody ClientEntity client){
        clientService.deleteClient(client);
    }
}
