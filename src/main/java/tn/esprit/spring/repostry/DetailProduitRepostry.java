package tn.esprit.spring.repostry;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entity.DetailProduit;

public interface DetailProduitRepostry extends CrudRepository <DetailProduit, Long> {

}
