package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.DAO.entity.DetailFactureEntity;

public interface DetailFactureRepository extends CrudRepository<DetailFactureEntity, Long> {

}
