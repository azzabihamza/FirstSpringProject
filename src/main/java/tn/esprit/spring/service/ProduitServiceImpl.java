package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.DetailProduit;
import tn.esprit.spring.DAO.Produit;
import tn.esprit.spring.repository.DetailProduitRepository;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;


@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
    RayonRepository rayonRepository;
	@Autowired
    StockRepository stockRepository;
	@Autowired
	DetailProduitRepository detailProduitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits= (List<Produit>) produitRepository.findAll();
		for (Produit produit: produits)
			System.out.println("produit : " + produit);
		return produits;
	}

	@Override
	@Transactional
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		p.setRayon(rayonRepository.findById(idRayon).orElse(null));
		p.setStock(stockRepository.findById(idStock).orElse(null));
		DetailProduit detailProduit= saveDetailProduit(p);
		p.setDetailProduit(detailProduit);
		produitRepository.save(p);
		return p;
	}

	private DetailProduit saveDetailProduit(Produit p) {
		if (p.getDetailProduit().getDateCreation() == null){
			p.getDetailProduit().setDateCreation(new java.sql.Date(new java.util.Date().getTime()));
			p.getDetailProduit().setDateDerniereModification(new Date());
		}else {
			p.getDetailProduit().setDateDerniereModification(new Date());
		}
		DetailProduit dp = detailProduitRepository.save(p.getDetailProduit());
		return dp;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).orElse(null);
		System.out.println("produit : "+ produit);
		return produit;
	}
}
