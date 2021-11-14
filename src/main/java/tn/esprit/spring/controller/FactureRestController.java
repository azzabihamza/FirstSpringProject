package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.Facture;
import tn.esprit.spring.service.FactureService;

import java.util.List;

@RestController
public class FactureRestController {
    @Autowired
    FactureService factureService;

    @GetMapping("getAllFactures")
    public List<Facture> getAllFactures(){
        return factureService.retrieveAllFactures();
    }

    @GetMapping("/getFacture/{idFacture}")
    public Facture retrieveFacture (@PathVariable("idFacture") Long idFacture){
        return factureService.retrieveFacture(idFacture);
    }

    @GetMapping("/getFactureByClient/{idClient}")
    public List<Facture> retrieveFactureByClient (@PathVariable("idClient") Long idClient){
        return factureService.retrieveFacturesByClient(idClient);
    }

    @PostMapping(value="/addFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFacture (@RequestBody Facture facture){
        factureService.createFacture(facture);
    }
}
