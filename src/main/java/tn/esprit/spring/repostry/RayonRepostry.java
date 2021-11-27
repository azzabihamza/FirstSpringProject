package tn.esprit.spring.repostry;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entity.Rayon;

public interface RayonRepostry extends CrudRepository<Rayon, Long> {

}
