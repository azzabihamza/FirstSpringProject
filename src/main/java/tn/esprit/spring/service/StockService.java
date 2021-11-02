package tn.esprit.spring.service;

import tn.esprit.spring.DAO.Stock;

import java.util.List;

public interface StockService {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);
}
