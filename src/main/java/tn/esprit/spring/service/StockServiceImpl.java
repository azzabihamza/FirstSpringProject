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
        List<Stock> stocks = (List<Stock>) stockRepository.findAll();
        for (Stock stock : stocks)
            System.out.println("stock : "+ stock);
        return stocks;
    }

    @Override
    public Stock addStock(Stock s) {
        stockRepository.save(s);
        return null;
    }

    @Override
    public Stock updateStock(Stock u) {
        stockRepository.save(u);
        return u;
    }

    @Override
    public Stock retrieveStock(Long id) {
        Stock stock = stockRepository.findById(id).orElse(null);
        System.out.println("stock : "+ stock);
        return stock;
    }
}
