package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.entity.Profession;
import tn.esprit.spring.service.ClientService;
import tn.esprit.spring.service.EmailServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ClientRestController {

    @Autowired
    ClientService clientService;

    @Autowired
    EmailServiceImpl emailService;

    @GetMapping("/getAllClients")
    public List<ClientEntity> getClients(){
        return clientService.retrieveAllClients();
    }

    // http://localhost:8089/SpringMVC/client/retrieve-client/8
    @GetMapping("/retrieve-client/{client-id}")
    @ResponseBody
    public ClientEntity retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.retrieveClient(clientId);
    }

    @GetMapping("/nbclient")
    @ResponseBody
    public int nbclient() {
        return clientService.countnbrclient();
    }

    @GetMapping("/nbr-fc-client/{client-id}")
    @ResponseBody
    public int CountFactByClient(@PathVariable("client-id") Long clientId) {
        List<FactureEntity> list =clientService.FactureParClient(clientId);
        return list.size();
    }

    @GetMapping("/facture/{client-id}")
    @ResponseBody
    public  List<FactureEntity> FactByClient(@PathVariable("client-id") Long clientId) {
        List<FactureEntity> list =clientService.FactureParClient(clientId);

        return list;
    }

    @GetMapping("/client/{client-id}")
    @ResponseBody
    public  ClientEntity clientById(@PathVariable("client-id") Long clientId) {
        ClientEntity list =clientService.retrieveClient(clientId);

        return list;
    }

    //methode1
    @GetMapping("/chiffre-affaire-by-cat/{categorie-client}/{start}/{end}")
    @ResponseBody
    public  float getChiffreAffaireParCategorieClient(@PathVariable("categorie-client") CategorieClient categorieClient, @PathVariable("start")  @DateTimeFormat(pattern="yyyy-MM-dd") Date StartDate, @PathVariable("end")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        Float CA =clientService.getChiffreAffaireParCategorieClient(categorieClient,StartDate,endDate);
        return CA;
    }

    @GetMapping("/chiffre-affaire-by-client/{idclient}")
    @ResponseBody
    public  float getChiffreAffaireParClient(@PathVariable("idclient")  Long id) {
        Float CA =clientService.getMoneySpentByOneClient(id);
        return CA;
    }

    //methode2
    @GetMapping("/chiffre-affaire-by-cat2/{categorie-client}/{start}/{end}")
    @ResponseBody
    public  float getChiffreAffaireParCategorieClient2(@PathVariable("categorie-client")  CategorieClient categorieClient,@PathVariable("start")  @DateTimeFormat(pattern="yyyy-MM-dd") Date StartDate,@PathVariable("end")@DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        Float CA =clientService.getChiffreAffaireParCategorieClient(categorieClient,StartDate,endDate);
        return CA;
    }

    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping(value="/add-client", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ClientEntity addClient(@RequestBody ClientEntity c)
    {
        ClientEntity client = clientService.addClient(c);
        return client;
    }

    // http://localhost:8089/SpringMVC/client/add-client
    @PostMapping("/add-client-repo")
    @ResponseBody
    public ClientEntity addClientRepo(@RequestBody ClientEntity c)
    {
        ClientEntity client = clientService.addClientRepo(c);
        return client;
    }


    // http://localhost:8089/SpringMVC/client/remove-client/{client-id}
    @DeleteMapping("/remove-client/{client-id}")
    @ResponseBody
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.deleteClient(clientId);
    }


    @GetMapping("/retrieve-client-byCategorieClient/{categorie-client}")
    @ResponseBody
    public List<ClientEntity> retrieveClientbyCategorie(@PathVariable("categorie-client") CategorieClient categorieClient) {

        return  clientService.retrieveClientbyCategorie(categorieClient);
    }

    @GetMapping("/retrieve-client-byProfession/{profession}")
    @ResponseBody
    public List<ClientEntity> retrieveClientbyProfession(@PathVariable("profession") Profession Profession) {
        return	clientService.retrieveClientbyProfession(Profession);
    }

    @GetMapping("/retrieve-client-byProfession-and-cat/{profession}/{categorie-client}")
    @ResponseBody
    public List<ClientEntity> retrieveClientbyProfessionAndCat(@PathVariable("profession") Profession Profession,@PathVariable("categorie-client") CategorieClient categorieClient) {
        return	clientService.retrieveClientbyCategorieAndProfession(Profession, categorieClient);
    }
    // http://localhost:8089/SpringMVC/client/modify-client
    @PutMapping("/modify-client")
    @ResponseBody
    public ClientEntity modifyClient(@RequestBody ClientEntity client) {
        return clientService.updateClient(client);
    }

    @PutMapping("/modify-client-by-id/{client-id}")
    @ResponseBody
    public ClientEntity modifyClientById(@RequestBody ClientEntity client,@PathVariable("client-id") Long clientId) {
        return clientService.updateClientById(client, clientId);
    }

}
