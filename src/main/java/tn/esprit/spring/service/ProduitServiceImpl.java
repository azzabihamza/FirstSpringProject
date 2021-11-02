package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.DAO.Produit;
import tn.esprit.spring.repository.ProduitRepository;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		for (Produit produit : produits) {
			System.out.println("produit : " + produit);
		}
		return produits;
	}

	@Override
	public Produit addProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
	}

	@Override
	public Produit updateClient(Produit p) {
		produitRepository.save(p);
		return p;
	}

	@Override
	public Produit retrieveClient(Long id) {
		Produit produit = produitRepository.findById(id).orElse(null);
		System.out.println("produit : " + produit);
		return produit;
	}

}
