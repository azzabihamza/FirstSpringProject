package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;

public interface ProduitService {

	List<ProduitEntity> retrieveAllProduits();

	public void addProduit(ProduitEntity p);

	ProduitEntity retrieveProduit(Long id);

	public void deleteProduit (Long id);

    public void updateProduit(ProduitEntity p);

    public List<ProduitEntity> retrieveProduitsByRayon(Long idRayon);

    public List<ProduitEntity> retrieveProduitsByStock(Long idStock);

    public List<ProduitEntity> retrieveProduitsByRayonAndStock(Long idRayon, Long idStock);

    public Float AffichageChiffreAffaire();

    //DAAMI Adem
    //affichage de la liste de fournisseur de chaque produit
    public List<FournisseurEntity> retrieveFournisseurByProduit(Long idProduit);
    //assignFournisseurToProduit
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;

}
