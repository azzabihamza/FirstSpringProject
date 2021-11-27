package tn.esprit.spring.repostry;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entity.Stock;

public interface StockRepostry extends CrudRepository<Stock, Long > {

}
