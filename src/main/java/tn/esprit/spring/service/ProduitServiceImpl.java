package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.entity.DetailProduitEntity;
import tn.esprit.spring.DAO.entity.ProduitEntity;
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
	DetailProduitService detailProduitService;

	@Override
	public List<ProduitEntity> retrieveAllProduits() {
		List<ProduitEntity> produits= (List<ProduitEntity>) produitRepository.findAll();
		for (ProduitEntity produit: produits)
			System.out.println("produit : " + produit);
		return produits;
	}

	@Override
	@Transactional
	public void addProduit(ProduitEntity p) {
		p.setRayon(rayonRepository.findById(p.getRayon().getIdRayon()).orElse(null));
		p.setStock(stockRepository.findById(p.getStock().getIdStock()).orElse(null));
		p.setDetailProduitEntity(saveDetailProduit(p));
		produitRepository.save(p);
	}

	private DetailProduitEntity saveDetailProduit(ProduitEntity p) {
		if (p.getDetailProduitEntity().getDateCreation() == null){
			p.getDetailProduitEntity().setDateCreation(new java.sql.Date(new java.util.Date().getTime()));
			p.getDetailProduitEntity().setDateDerniereModification(new java.sql.Date(new java.util.Date().getTime()));
		}else {
			p.getDetailProduitEntity().setDateDerniereModification(new java.sql.Date(new java.util.Date().getTime()));
		}
		detailProduitService.addDetailProduit(p.getDetailProduitEntity());

		return p.getDetailProduitEntity();
	}

	@Override
	public ProduitEntity retrieveProduit(Long id) {
		ProduitEntity produit = produitRepository.findById(id).orElse(null);
		System.out.println("produit : "+ produit);
		return produit;
	}

	@Override
	public void deleteProduit(Long id) {
		ProduitEntity produit = produitRepository.findById(id).orElse(null);
		if(produit != null) {
			detailProduitService.deleteDetailProduit(produit.getDetailProduitEntity().getIdDetailProduit());
			produitRepository.delete(produit);
		}
	}

	@Override
	public void updateProduit(ProduitEntity p) {
        produitRepository.save(p) ;
	}

	@Override
	public List<ProduitEntity> retrieveProduitsByRayon(Long idRayon) {
	    return null;
	}

	@Override
	public List<ProduitEntity> retrieveProduitsByStock(Long idStock) {
		return null;
	}

	@Override
	public List<ProduitEntity> retrieveProduitsByRayonAndStock(Long idRayon, Long idStock) {
		return null;
	}
}
