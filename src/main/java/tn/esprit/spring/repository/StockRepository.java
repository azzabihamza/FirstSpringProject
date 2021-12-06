package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.response.OrderResponse;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StockRepository extends CrudRepository<Stock, Long> {
    @Query("SELECT s FROM Stock s WHERE s.libelleStock= :test")
    List<Stock> retrievestocksbylibelle(@Param("test") String test);

    @Query("SELECT s FROM Stock s WHERE s.qteStock=0 and s.idStock=:test")
    Stock retrivenoqtestocks (@Param ("test") long test);
    List<Stock> findByqteStockLessThan(int qtestock);

    int countByqteMin(int qtemin);

   /* @Query("SELECT new responses.OrderResponse(s.libelleStock,s.qteStock, p.libelleProduit, p.prixUnitaire) FROM Stock s RIGHT JOIN Produit p ON s.idStock = p.stock.idStock")
    List<OrderResponse> retrieveproduitsandstocks();

    @Query("SELECT new responses.OrderResponse(s.libelleStock,s.qteStock, p.libelleProduit, p.prixUnitaire) FROM Stock s RIGHT JOIN Produit p ON s.idStock = p.stock.idStock AND s.libelleStock = :test")
    List<OrderResponse> retrieveproduitsandstocksbylibelle(@Param ("test") String test); */

    @Query("SELECT s FROM Stock s WHERE s.qteStock= :test")
    List<Stock> retrievestocksbyqtestock(@Param ("test") String test);

    @Query("SELECT AVG(s.qteStock) FROM Stock s")
    float retrieveavgstocksbylibstock();

    @Query("SELECT COUNT(s.qteStock) FROM Stock s WHERE s.qteStock<s.qteMin")
    int retreievecount();


    @Query("SELECT s FROM Stock s WHERE s.qteStock BETWEEN :test AND :test2")
    List<Stock> retrievestocksbyqtestockbetween(@Param ("test") int test,@Param ("test2") int test2);

    @Query("SELECT s FROM Stock s WHERE s.qteMin= :test")
    List<Stock> retrievestocksbyqteMin(@Param ("test") String test);


    @Modifying
    @Transactional
    @Query("update Stock s set s.qteStock = :qtes where s.libelleStock = :libstock")
    void updatestockqtebylibelle(@Param("qtes") int qtes,@Param ("libstock") String libstock);

    @Modifying
    @Transactional
    @Query("update Stock s set s.qteMin = :qtmin where s.qteStock = :qtestock")
    void updatestockqtebylibelles(@Param("qtmin") int qtemin,@Param("qtestock") int qtest);

    @Modifying
    @Transactional
    @Query("DELETE FROM Stock s WHERE s.libelleStock= :test AND s.qteMin = :qtemin")
    void deletestockbylibandqtmin(@Param("test") String test, @Param("qtemin") int qtemin);

}
