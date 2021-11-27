package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.ProduitEntity;

import java.util.List;

public interface ProduitRepository extends CrudRepository<ProduitEntity, Long> {

    @Query("select p from ProduitEntity p where p.prixUnitaire between :min and :max")
    List<ProduitEntity> retrieveProduitByPriceRange(@Param("min") double min, @Param("max") double max);

    @Query("SELECT p from ProduitEntity p order by p.prixUnitaire desc ")
    List<ProduitEntity> retireveAllProduitByPriceDesc();

    @Query("SELECT p from ProduitEntity p order by p.prixUnitaire asc ")
    List<ProduitEntity> retireveAllProduitByPriceAsc();

    @Query("SELECT p from ProduitEntity p where p.libelleProduit like :x")
    List<ProduitEntity> retrieveProduitByLibelle(@Param("x") String x);


}
