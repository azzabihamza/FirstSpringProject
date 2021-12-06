package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.Profession;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    @Query("select c from ClientEntity c where c.profession = :profession")
    List<ClientEntity> retrieveClientsByProffession(@Param("profession")Profession profession);

    @Modifying
    @Query("update ClientEntity c set c.categorieClient = :categorie where c.profession = :profession")
    int updateClientCategorieByProffession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Modifying
    @Query("DELETE FROM ClientEntity c where c.categorieClient= :categorie and c.profession= :profession")
    Long deleteClientByCategorieClientAndProfession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Query("select c from ClientEntity c where c.dateNaissance between :date1 and :date2")
    List<ClientEntity> retrieveClientsBetweenDates(@Param("date1")String date1, @Param("date2")String date2);
}
