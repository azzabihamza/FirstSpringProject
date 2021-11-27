package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entity.Produit;

public interface IProduitService {
	public List <Produit> retrieveAllProduit(); 
	public Produit addProduit(Produit p, Long idRayon , Long idStock); 
	public void deleteProduit (Long id); 
	public Produit UpdateProduit (Produit p) ; 
	public Produit retrieveProduit(Long id ); 

}
