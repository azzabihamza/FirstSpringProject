package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.DAO.entity.DetailProduitEntity;

public interface DetailProduitRepository extends CrudRepository<DetailProduitEntity, Long> {

    @Query("select max(idDetailProduit) from DetailProduitEntity")
    DetailProduitEntity getLastDetailProduitAdded();
}
