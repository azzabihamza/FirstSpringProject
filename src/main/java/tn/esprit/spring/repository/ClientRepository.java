package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.CategorieClient;
import tn.esprit.spring.DAO.Client;
import tn.esprit.spring.DAO.Profession;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("select c from Client c where c.profession = :profession")
    List<Client> retrieveClientsByProffession(@Param("profession")Profession profession);

    @Modifying
    @Query("update Client c set c.categorieClient = :categorie where c.profession = :profession")
    int updateClientCategorieByProffession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Modifying
    @Query("DELETE FROM Client c where c.categorieClient= :categorie and c.profession= :profession")
    Long deleteClientByCategorieClientAndProfession(@Param("categorie")CategorieClient categorieClient, @Param("profession")Profession profession);

    @Query("select c from Client c where c.dateNaissance between :date1 and :date2")
    List<Client> retrieveClientsBetweenDates(@Param("date1")String date1,@Param("date2")String date2);
}
