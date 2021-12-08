package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.service.ProduitService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

    @GetMapping(value = "getAllProduits")
    public List<ProduitEntity> getAllProduits(){
        return produitService.retrieveAllProduits();
    }

    @PostMapping(value = "addProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addProduit(@RequestBody ProduitEntity produitEntity){
        produitService.addProduit(produitEntity);
    }
    @PutMapping(value = "/updateProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateProduit(@RequestBody ProduitEntity produit){produitService.updateProduit(produit);
    }
    @DeleteMapping("/deleteProduit/{idProduit}")
    public void deleteProduit(@PathVariable("idProduit") Long idProduit){
        produitService.deleteProduit(idProduit);
    }

    @GetMapping(value = "/getChiffreAffaire")
    public float AffichageChiffreAffaire() {
        return produitService.AffichageChiffreAffaire();
    }

    }


