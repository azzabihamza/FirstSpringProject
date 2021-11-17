package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.Produit;

public interface ProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
}
