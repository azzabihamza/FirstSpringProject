package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.Produit;

public interface ProduitService {

	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p);

	void deleteProduit(Produit p);

	Produit updateClient(Produit p);

	Produit retrieveClient(Long id);
}
