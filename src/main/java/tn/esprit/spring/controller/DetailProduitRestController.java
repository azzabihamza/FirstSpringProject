package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.DAO.entity.DetailProduitEntity;
import tn.esprit.spring.service.DetailProduitService;


import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DetailProduitRestController {

    @Autowired
    DetailProduitService detailProduitService;

    @GetMapping(value = "getDetailProduits")
    public List<DetailProduitEntity> getAllDetailProduits(){
        return detailProduitService.retrieveAllDetailProduits();
    }

    @PutMapping(value = "updateDetailProduit", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDetailProduit(@RequestBody DetailProduitEntity detailProduitEntity){
        detailProduitService.updateDetailProduit(detailProduitEntity);
    }
}
