package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;

public interface DetailFactureRepository extends CrudRepository<DetailFactureEntity, Long> {

    @Query("select d from DetailFactureEntity d where d.idDetailFacture = :id")
    DetailFactureEntity retieveDetailFactureById(@Param("id") Long id);

}
