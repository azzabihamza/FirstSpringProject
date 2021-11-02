package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Stock;
import tn.esprit.spring.repository.StockRepository;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    StockRepository stockRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return null;
    }

    @Override
    public Stock addStock(Stock s) {
        return null;
    }

    @Override
    public Stock updateStock(Stock u) {
        return null;
    }

    @Override
    public Stock retrieveStock(Long id) {
        return null;
    }
}
