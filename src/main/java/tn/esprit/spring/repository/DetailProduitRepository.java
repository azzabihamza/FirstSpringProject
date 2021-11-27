package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.DAO.entity.DetailProduitEntity;

public interface DetailProduitRepository extends CrudRepository<DetailProduitEntity, Long> {

}
