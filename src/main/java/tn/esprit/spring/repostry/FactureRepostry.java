package tn.esprit.spring.repostry;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entity.Facture;

public interface FactureRepostry extends CrudRepository<Facture, Long> {

}
