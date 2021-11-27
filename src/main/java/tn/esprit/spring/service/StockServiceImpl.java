package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.Stock;
import tn.esprit.spring.repostry.*;

@Service 
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepostry StockRepostry ;
	
	@Override
	public List<Stock> retrieveAllStock() {
		// TODO Auto-generated method stub
		System.out.println(StockRepostry.findAll());
		
		return (List<Stock>) StockRepostry.findAll();
	
	}

	@Override
	public Stock addStock(Stock S) {
		// TODO Auto-generated method stub
		 StockRepostry.save(S); 
			return S;

	}

	@Override
	public void deleteStock(Long id) {
		// TODO Auto-generated method stub
		StockRepostry.deleteById(id);

		
	}

	@Override
	public Stock UpdateStock(Stock S) {
		// TODO Auto-generated method stub
		List<Stock> Stock = (List<Stock>) StockRepostry.save(S);
		return S;}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		Stock S ; 
		S= StockRepostry.findById(id).get();
		
		return S;}

}
