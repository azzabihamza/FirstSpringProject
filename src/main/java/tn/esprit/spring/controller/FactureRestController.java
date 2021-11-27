package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.model.Facture;
import tn.esprit.spring.service.FactureService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
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

    @PutMapping(value = "/updateFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateFacture(@RequestBody Facture facture){
        factureService.updateFacture(facture);
    }

    @PutMapping(value="/changeStatus", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void changeStatus(@RequestBody Facture facture){
        factureService.cancelFacture(facture);
    }

    @DeleteMapping("/deleteFacture/{idFacture}")
    public void deleteFacture(@PathVariable("idFacture") Long idFacture){
        factureService.deleteFacture(idFacture);
    }

    @PostMapping(value="/addFacture", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addFacture (@RequestBody Facture facture){
        factureService.createFacture(facture);
    }

    @GetMapping("/getInActiveFacture")
    public List<Facture> getInActiveFacture(){
        return factureService.retrieveFacturesInActive();
    }

    @GetMapping("/getActiveFacture")
    public List<Facture> getActiveFacture(){
        return factureService.retrieveFacturesActive();
    }

    @GetMapping("/getFacturesByDateDesc")
    public List<Facture> getAllFacturesByDateDesc(){
        return factureService.retrieveFacturesByDateDesc();
    }

    @GetMapping("/getFacturesByDateAsc")
    public List<Facture> getAllFacturesByDateAsc(){
        return factureService.retrieveFacturesByDateAsc();
    }

    @GetMapping("/getFacturesByDateBetween/{date1}/{date2}")
    public List<Facture> getAllFacturesByDateBetween(@PathVariable("date1") String date1, @PathVariable("date2") String date2){
        return factureService.retrieveFacturesBetweenDates(date1,date2);
    }


}
