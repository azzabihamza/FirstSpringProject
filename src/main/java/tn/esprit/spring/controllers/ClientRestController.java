package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entity.Client;
import tn.esprit.spring.dao.entity.Profession;
import tn.esprit.spring.service.IClientService;

@CrossOrigin(origins = "http://localhost:9595")
@RestController
public class ClientRestController {
	
   @Autowired
   IClientService clientservice;
   //affichage 
   // http://localhost:8089/SpringMVC/servlet/retrieveClients
   @GetMapping("retrieveClients")
   public List<Client> getClient(){
   return clientservice.retrieveAllClient();
   }
   //affichage par id
   // http://localhost:8089/SpringMVC/servlet/retrieveClient/1
   @GetMapping("/retrieveClient/{clientId}")
   public Client retrieveClient(@PathVariable("clientId") Long clientId) {
	   	return clientservice.retrieveClient(clientId);
   }
   
   //ajout
//http://localhost:8089/SpringMVC/servlet/addClients
   @PostMapping("/addClients")
   @ResponseBody
   public Long addClient(@RequestBody Client c){
	   Client client=clientservice.addClient(c);
	   return c.getIdClient();
	   
   }
   //supprimer
   // http://localhost:8089/SpringMVC/servlet/removeClients/3
   @DeleteMapping("/removeClients/{clientId}")
   public void removeClient(@PathVariable("clientId") Long clientId){
	    clientservice.deleteClient(clientId);
   }
   
   
   //update
   //http://localhost:8089/SpringMVC/servlet/updateClients
   @PutMapping("/updateClients")
   @ResponseBody
   public Client modifyClient(@RequestBody Client c){
	   return  clientservice.UpdateClient(c);
	   
   }
 //http://localhost:8089/SpringMVC/servlet/updateClientCategorieByProfession
   /*@PutMapping("/updateClientCategorieByProfession")
   @ResponseBody
   public Long updateClientCategorieByProfession(@RequestBody CategorieClient categorieC,@RequestBody Role professionC){
	   return clientservice.updateClientCategorieByProfession(categorieC, professionC);
   }*/

   

}