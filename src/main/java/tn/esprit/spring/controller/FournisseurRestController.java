package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.service.IFournisseurService;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FournisseurRestController {

    @Autowired
    IFournisseurService fournisseurservice;
    //affichage
    // http://localhost:8089/SpringMVC/servlet/retrieveClients
    @GetMapping("retrieveFournisseur")
    public List<FournisseurEntity> getFournisseur(){
        return fournisseurservice.retrieveAllFournisseur();
    }
    //affichage par id
    // http://localhost:8089/SpringMVC/servlet/retrieveClient/1
    @GetMapping("/retrieveFournisseur/{FournisseurId}")
    public FournisseurEntity retrieveFournisseur(@PathVariable("FournisseurId") Long FournisseurId) {
        return fournisseurservice.retrieveFournisseur(FournisseurId);
    }

    //ajout
    //http://localhost:9595/SpringMVC/servlet/addFournisseur
    @PostMapping(value="/addFournisseur", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Long addFournisseur(@RequestBody FournisseurEntity f){
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
    @PutMapping(value="/updateFournisseur", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FournisseurEntity modifyFournisseur(@RequestBody FournisseurEntity f){
        return  fournisseurservice.UpdateFournisseur(f);

    }


    //affichage par categorieProduit
    // http://localhost:9595/SpringMVC/servlet/retrieveFournisseurByCat/ELECTROMENAGER
    @GetMapping("/retrieveFournisseurByCat/{categorieProduit}")
    public  List<FournisseurEntity> retrieveFournisseurByCategorieProduit(@PathVariable("categorieProduit") String  categorieProduit) {
        return fournisseurservice.retrieveFournissersByCategorieProduit(categorieProduit)	;   }

    //affichage par date de creation
    // http://localhost:9595/SpringMVC/servlet/retrieveFournisseurByDate/2020-01-01/2021-01-01
    @GetMapping("/retrieveFournisseurBydat/{dateDebut}/{dateFin}")
    public List<FournisseurEntity> retrieveFournisseurByDateCreation(@PathVariable("dateDebut") String dateDebut, @PathVariable("dateFin") String dateFin ){
        return fournisseurservice.retrieveFournissersByDateCreation(dateDebut, dateFin)	;   }


    //nombre de fournisseur par categorie de produit
    // http://localhost:9595/SpringMVC/servlet/CountDistinctByCat/ELECTROMENAGER
    @GetMapping("/CountDistinctByCat/{categorieProduit}")
    public int CountDistinctByCategorieProduit(@PathVariable("categorieProduit") String categorieProduit){
        return fournisseurservice.CountDistinctByCategorieProduit(categorieProduit);
    }


    //nombre de fournisseur par date de creation et categorie de produit
    // http://localhost:9595/SpringMVC/servlet/CountDistinctByCategorieProduitbydate/ALIMENTAIRE/01-01-2020/01-01-2021
    @GetMapping("/CountDistinctByCategorieProduitbydate/{categorieProduit}/{dateDebut}/{dateFin}")
    public int CountDistinctByCategorieProduitbydate(@PathVariable("categorieProduit") String categorieProduit, @PathVariable("dateDebut") String dateDebut, @PathVariable("dateFin") String dateFin ){
        return fournisseurservice.CountDistinctByCategorieProduitbydate(categorieProduit, dateDebut, dateFin).size();   }


    //nombre total de fournisseur
    // http://localhost:9595/SpringMVC/servlet/nombreTotalFournisseur
    @GetMapping("/nombreTotalFournisseur")
    public int nombreTotalFournisseur(){
        return fournisseurservice.nombreTotalFournisseur();
    }

    // ajouter un fournisseur au produit
    // http://localhost:9595/SpringMVC/servlet/assignFournisseurToProduit/25/1
    @PostMapping("/assignFournisseurToProduit/{idFournisseur}/{idProduit}")
    public void assignFournisseurToProduit(Long idFournisseur, Long idProduit){
        fournisseurservice.assignFournisseurToProduit(idFournisseur, idProduit);
    }

	/*
	   //affichage de produits d'un fournisseur
	  // http://localhost:9595/SpringMVC/servlet/retrieveProduitsOfFournisseur/25
		   @GetMapping("/retrieveProduitsOfFournisseur/{idFournisseur}")
		   public void retrieveProduitsOfFournisseur(Long idFournisseur){
			   fournisseurservice.retrieveProduitsOfFournisseur(idFournisseur);
		   }*/



    //

}
