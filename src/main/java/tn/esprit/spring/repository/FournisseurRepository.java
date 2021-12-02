package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.CategorieProduit;
import tn.esprit.spring.DAO.entity.FournisseurEntity;

import java.util.List;

public interface FournisseurRepository extends CrudRepository<FournisseurEntity, Long> {

    @Query("select f from FournisseurEntity f where f.categorieProduit = :cat")
    List<FournisseurEntity> retrieveFournissersByCategorieProduit(@Param("cat") String categorieProduit);

    @Query("SELECT f FROM FournisseurEntity f WHERE f.dateCreation BETWEEN :dateDebut AND :dateFin")
    List<FournisseurEntity> retrieveFournissersByDateCreation(@Param("dateDebut") String dateDebut,@Param("dateFin") String dateFin );

    //calcul de nombre de fournisseur distinct dans la meme categorie de produit
    @Query("SELECT COUNT(DISTINCT codeFournisseur) FROM FournisseurEntity WHERE categorieProduit = :cat")
    int CountDistinctByCategorieProduit(@Param("cat") String  categorieProduit);


    //calcul de nombre de fournisseur par date de creation de la meme categorie
    @Query("SELECT f FROM FournisseurEntity f WHERE f.categorieProduit = :cat or f.dateCreation BETWEEN :dateDebut and :dateFin")
    List<FournisseurEntity> CountDistinctByCategorieProduitbydate(@Param("cat") String categorie_produit, @Param("dateDebut") String dateDebut,@Param("dateFin") String dateFin );

    //calcul de nombre total de fournisseur
    @Query("SELECT COUNT(*) FROM FournisseurEntity ")
    int nombreTotalFournisseur();
		/*
		//affichage les produits de fournisseur
		@Query("select * FROM `produit` where produit.id_produit like (SELECT produit_fournisseurs.produit_id_produit FROM `produit_fournisseurs` WHERE `produit_fournisseurs`.`fournisseurs_id_fournisseur` like :idf)")
		List<Produit> retrieveProduitsOfFournisseur(@Param("idf") Long idf);*/

}
