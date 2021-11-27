package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dao.entity.*;
import tn.esprit.spring.service.IClientService;
import tn.esprit.spring.service.IFournisseurService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FournisseurRestControllers {

	   @Autowired
	   IFournisseurService fournisseurservice;
	   //affichage 
	   // http://localhost:8089/SpringMVC/servlet/retrieveClients
	   @GetMapping("retrieveFournisseur")
	   public List<Fournisseur> getFournisseur(){
	   return fournisseurservice.retrieveAllFournisseur();
	   }
	   //affichage par id
	   // http://localhost:8089/SpringMVC/servlet/retrieveClient/1
	   @GetMapping("/retrieveFournisseur/{FournisseurId}")
	   public Fournisseur retrieveFournisseur(@PathVariable("FournisseurId") Long FournisseurId) {
		   	return fournisseurservice.retrieveFournisseur(FournisseurId);
	   }
	   
	   //ajout
	//http://localhost:9595/SpringMVC/servlet/addFournisseur
	   @PostMapping("/addFournisseur")
	   @ResponseBody
	   public Long addFournisseur(@RequestBody Fournisseur f){
		   fournisseurservice.addFournisseur(f);
		   return f.getIdFournisseur();
		   
	   }
	   //supprimer
	   // http://localhost:8089/SpringMVC/servlet/removeFourisseurs/3
	   @DeleteMapping("/removeFourisseurs/{fournisseurId}")
	   public void removeFournisseur(@PathVariable("fournisseurId") Long fournisseurId){
		    fournisseurservice.deleteFournisseur(fournisseurId);
	   }
	   
	   
	   //update
	   //http://localhost:9595/SpringMVC/servlet/updateFournisseur
	   @PutMapping("/updateFournisseur")
	   @ResponseBody
	   public Fournisseur modifyFournisseur(@RequestBody Fournisseur f){
		   return  fournisseurservice.UpdateFournisseur(f);
		   
	   }

	   
	 //affichage par categorieProduit
	   // http://localhost:9595/SpringMVC/servlet/retrieveFournisseurByCat/ELECTROMENAGER
	   @GetMapping("/retrieveFournisseurByCat/{categorieProduit}")
	   public  List<Fournisseur> retrieveFournisseurByCategorieProduit(@PathVariable("categorieProduit") CategorieProduit categorieProduit) {
		   	return fournisseurservice.retrieveClientsByCategorieProduit(categorieProduit)	;   }

	   //affichage par date de creation 
	   // http://localhost:9595/SpringMVC/servlet/retrieveFournisseurByDate/2020-01-01/2021-01-01
	   @GetMapping("/retrieveFournisseurBydat/{dateDebut}/{dateFin}")
		public List<Fournisseur> retrieveFournisseurByDateCreation(@PathVariable("dateDebut") String dateDebut, @PathVariable("dateFin") String dateFin ){
		   	return fournisseurservice.retrieveClientsByDateCreation(dateDebut, dateFin)	;   }

	   
	   //nombre de fournisseur par categorie de produit 
	// http://localhost:9595/SpringMVC/servlet/CountDistinctByCat/ELECTROMENAGER
	   @GetMapping("/CountDistinctByCat/{categorieProduit}")
	   public int CountDistinctByCategorieProduit(@PathVariable("categorieProduit") CategorieProduit categorieProduit){
		   return fournisseurservice.CountDistinctByCategorieProduit(categorieProduit);
	   }
	   
	   
	   //nombre de fournisseur par date de creation et categorie de produit 
	  // http://localhost:9595/SpringMVC/servlet/CountDistinctByCategorieProduitbydate/ALIMENTAIRE/01-01-2020/01-01-2021
	   @GetMapping("/CountDistinctByCategorieProduitbydate/{categorieProduit}/{dateDebut}/{dateFin}")
		public int CountDistinctByCategorieProduitbydate(@PathVariable("categorieProduit") CategorieProduit categorieProduit, @PathVariable("dateDebut") String dateDebut, @PathVariable("dateFin") String dateFin ){
		   	return fournisseurservice.CountDistinctByCategorieProduitbydate(categorieProduit, dateDebut, dateFin)	;   }
	   
	   
	   //nombre total de fournisseur
	// http://localhost:9595/SpringMVC/servlet/nombreTotalFournisseur
	   @GetMapping("/nombreTotalFournisseur")
	   public int nombreTotalFournisseur(){
		   return fournisseurservice.nombreTotalFournisseur();
	   }
	   
	   
	   //
	   


}
