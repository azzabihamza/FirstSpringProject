package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entity.Stock;

public interface IStockService {
	public List <Stock> retrieveAllStock(); 
	public Stock addStock(Stock S); 
	public void deleteStock (Long id); 
	public Stock UpdateStock (Stock S ) ; 
	public Stock retrieveStock(Long id ); 

}
