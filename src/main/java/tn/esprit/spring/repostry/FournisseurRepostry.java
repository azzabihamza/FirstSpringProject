package tn.esprit.spring.repostry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.dao.entity.CategorieProduit;
import tn.esprit.spring.dao.entity.Fournisseur;

@Repository
public interface FournisseurRepostry extends  CrudRepository<Fournisseur, Long> {

	
	@Query("select f from Fournisseur f where f.categorieProduit like :cat")
	List<Fournisseur> retrieveClientsByCategorieProduit(@Param("cat") CategorieProduit categorie_produit);
	
	@Query("SELECT f FROM Fournisseur f WHERE f.dateCreation BETWEEN :dateDebut AND :dateFin")
	List<Fournisseur> retrieveClientsByDateCreation(@Param("dateDebut") String dateDebut,@Param("dateFin") String dateFin );
	
	//calcul de nombre de fournisseur distinct dans la meme categorie de produit 
	@Query("SELECT COUNT(DISTINCT codeFournisseur) FROM Fournisseur WHERE categorieProduit like :cat")
	int CountDistinctByCategorieProduit(@Param("cat") CategorieProduit categorie_produit);

	
	//calcul de nombre de fournisseur par date de creation de la meme categorie 
		@Query("SELECT COUNT(*) FROM Fournisseur WHERE categorieProduit like :cat or dateCreation BETWEEN :dateDebut and :dateFin")
		int CountDistinctByCategorieProduitbydate(@Param("cat") CategorieProduit categorie_produit, @Param("dateDebut") String dateDebut,@Param("dateFin") String dateFin );
	
	//calcul de nombre total de fournisseur 
		@Query("SELECT COUNT(*) FROM Fournisseur")
		int nombreTotalFournisseur();
	

}
