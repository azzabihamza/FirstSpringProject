package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.Produit;

import java.util.List;

public interface ProduitRepository extends CrudRepository<Produit, Long> {

    @Query("select p from Produit p where p.prixUnitaire between :min and :max")
    List<Produit> retrieveProduitByPriceRange(@Param("min") double min, @Param("max") double max);

    @Query("SELECT p from Produit p order by p.prixUnitaire desc ")
    List<Produit> retireveAllProduitByPriceDesc();

    @Query("SELECT p from Produit p order by p.prixUnitaire asc ")
    List<Produit> retireveAllProduitByPriceAsc();
}
