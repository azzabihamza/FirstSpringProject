package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import tn.esprit.spring.DAO.Facture;

import java.util.List;

public interface FactureRepository extends CrudRepository<Facture, Long> {

    @Query("select * from Facture where active = true ")
    List<Facture> retrieveAllActiveFacture();

    @Query("select * from Facture where active = false ")
    List<Facture> retrieveAllInActiveFacture();

    @Query("select * from Facture where dateFacture between :date1 and :date2")
    List<Facture> retirveAllFactureBetweenDate(@Param("date1") String date1, @Param("date2") String date2);

    @Query("SELECT * from Facture order by dateFacture desc ")
    List<Facture> retrieveAllFactureByDateFactureDesc();

    @Query("select * from Facture order by dateFacture")
    List<Facture> retrieveAllFactureByDateFactureAsc();
}
