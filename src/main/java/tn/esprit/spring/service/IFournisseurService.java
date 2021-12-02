package tn.esprit.spring.service;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.FournisseurEntity;

import java.util.List;

public interface IFournisseurService {

    public List<FournisseurEntity> retrieveAllFournisseur();
    public FournisseurEntity addFournisseur(FournisseurEntity p);
    public void deleteFournisseur (Long id);
    public FournisseurEntity UpdateFournisseur (FournisseurEntity F) ;
    public FournisseurEntity retrieveFournisseur(Long id );
    public List<FournisseurEntity> retrieveFournissersByCategorieProduit(String categorie_produit);
    public List<FournisseurEntity> retrieveFournissersByDateCreation(String dateDebut, String dateFin );
    public int CountDistinctByCategorieProduit(String categorie_produit);
    public List<FournisseurEntity> CountDistinctByCategorieProduitbydate(String categorie_produit,  String dateDebut, String dateFin );
    public int nombreTotalFournisseur();
    public void assignFournisseurToProduit(Long idFournisseur, Long idProduit);
    //public List<Produit> retrieveProduitsOfFournisseur(@Param("idf") Long idf);
}
