package tn.esprit.spring.repostry;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entity.Produit;

public interface ProduitRepostry extends CrudRepository<Produit, Long> {

}
