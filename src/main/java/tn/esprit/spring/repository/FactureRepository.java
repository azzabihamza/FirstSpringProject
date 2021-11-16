package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.Facture;

import java.util.List;

public interface FactureRepository extends CrudRepository<Facture, Long> {

    @Query("select f from Facture f where f.active = true ")
    List<Facture> retrieveAllActiveFacture();

    @Query("select f from Facture f where f.active = false ")
    List<Facture> retrieveAllInActiveFacture();

    @Query("select f from Facture f where f.dateFacture between :date1 and :date2")
    List<Facture> retirveAllFactureBetweenDate(@Param("date1") String date1, @Param("date2") String date2);

    @Query("SELECT f from Facture f order by f.dateFacture desc ")
    List<Facture> retrieveAllFactureByDateFactureDesc();

    @Query("select f from Facture f order by f.dateFacture")
    List<Facture> retrieveAllFactureByDateFactureAsc();

    @Query("select f from Facture f where f.idFacture = :idFacture")
    Facture retrieveFactureById(@Param("idFacture") Long idFacture);


}
