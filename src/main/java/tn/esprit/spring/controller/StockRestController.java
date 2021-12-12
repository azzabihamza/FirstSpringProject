package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.response.Fournisseurprod;
import tn.esprit.spring.DAO.entity.FournisseurEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
import tn.esprit.spring.DAO.entity.Stock;
import tn.esprit.spring.response.OrderResponse;
import tn.esprit.spring.service.StockService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class StockRestController {
	@Autowired
	StockService stockservice;

	
	@GetMapping("/getAllStocks")
	public List<Stock> getStocks(){
		List<Stock> liststocks = stockservice.retrieveAllStocks();
		return liststocks;
	}
	
	
	@GetMapping("/getAllqtes")
	public List<Stock> getallqtandqtmin(){
		List<Stock> liststocks = stockservice.retrieveqtestockandqtemin();
		return liststocks;
	}
	@GetMapping("/retrieve-stockbylibelle/{stock-libelle}")
	public List<Stock> retrivestocksbylib(@PathVariable("stock-libelle") String stockLibelle){
		List<Stock> liststocks = stockservice.retrieveStocksByLibelle(stockLibelle);
		return liststocks;
	}
	@GetMapping("/getAllStocksandproducts")
	public List<OrderResponse> getStocksandproducts(){
		List<OrderResponse> liststocks =stockservice.retrieveproduitandstock();
		return liststocks;

	}
	@GetMapping("/getAllproductsbyidstockandfour/{stock-id}")

	public List<ProduitEntity> retrieveproduitsparfournisseursetstocks(@RequestBody FournisseurEntity p, @PathVariable("stock-id")  Long test)
	{
		return stockservice.retrieveproduitsparfournisseursetstocks(p, test);
	}
	
	@GetMapping("/getAllStocksandprodsbylib/{stock-libelle}")
	public List<OrderResponse> getStocksandproducts(@PathVariable("stock-libelle") String stockLibelle){
		List<OrderResponse> liststocks =stockservice.retrieveproduitsandstocksbylibelle(stockLibelle);
		return liststocks;

	}
	@GetMapping("/retrievestockparidstockdeproduit/{id-stock}/{lib-p}")
	public List<Stock> retrievestockparidstockdeproduit(@PathVariable("id-stock") Long stockId,@PathVariable("lib-p") String libp){
		return stockservice.retrievestockparidstockdeproduit(stockId,libp);

	}
	
	@GetMapping("/retrievefournisseurandlibprodparstock/{stock-id}")
	public List <Fournisseurprod> retrievefournisseurandlibprodparstock(@PathVariable("stock-id") Long stockId)
	{
		return stockservice.retrievefournisseurandlibprodparstock(stockId);
	}
	
	@GetMapping("/retrieve-stock/{stock-id}")
	public Stock retrieveStock(@PathVariable("stock-id") Long stockId) {
	return stockservice.retrieveStock(stockId);
	}
	@GetMapping("/retrieveavgqtestock")
	public float retrieveavgqteStock() {
	return stockservice.retrieveavgstocksbylibstock();
	}
	
	@GetMapping("/retrievecountqtestockinf")
	public int retrievecountstock() {
	return stockservice.retreievecount();
	}
	
	@GetMapping("/retrieve-qtestocksstockbetween/{var1}/{var2}")
	public List<Stock> retrieveqtestocksStockbetween(@PathVariable("var1") int var1,@PathVariable("var2") int var2) {
	return stockservice.retrievestocksbyqtestockbetween(var1,var2);
	}
	
	@GetMapping("/lessthanqte/{var1}")
	public List<Stock> lessthanqte(@PathVariable("var1") int var1) {
	return stockservice.stockqtelessthan(var1);
	}
	@GetMapping("/countingstockbyqtemin/{var1}")
	public int counting(@PathVariable("var1") int var1) {
	return stockservice.countbyqtemin(var1);
	}
	
	@PostMapping("/add-stock")
	public Stock addStock(@RequestBody Stock c)
	{
		Stock stock = stockservice.addStock(c);
	return stock;
	}
	@DeleteMapping("/remove-stock/{stock-id}")
	public void removeStock(@PathVariable("stock-id") Long stockId) {
		stockservice.deleteStock(stockId);
	}
	
	@DeleteMapping("/remove-stocktest/{stock-lib}/{stock-qtemin}")
	public void removeStock2(@PathVariable("stock-lib") String stocklib,@PathVariable("stock-qtemin") int qtemin) {
		stockservice.deletebylibandminqte(stocklib, qtemin);
	}
	@PutMapping("/modify-stock")
	
	public Stock modifyStock(@RequestBody Stock stock) {
	return stockservice.updateStock(stock);
	}
	
@PutMapping("/modify-stock/{idprod}/{idstock}")	
	public void assignprodtostock(@PathVariable("idprod") Long idprod,@PathVariable("idstock") Long idStock) {
	 stockservice.assignProduitToStock(idprod, idStock);
	}
	
	
	
	@PutMapping("/modifyqte-stockbylib/{qte}/{lib}")
	
	public void modifyqteStockbylib(@PathVariable("qte") int qte,@PathVariable("lib") String lib) {
 stockservice.updatestockqtebylibelle(qte, lib);
	}
	
}