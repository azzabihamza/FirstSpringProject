package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.DetailProduit;
import tn.esprit.spring.dao.entity.Produit;

import tn.esprit.spring.repostry.*;


@Service
public class ProduitServiceImpl implements IProduitService {
	
	@Autowired
	ProduitRepostry ProduitRepostry ; 

	@Autowired
	RayonRepostry RayonRepostry ;

	@Autowired
	DetailProduitRepostry DetailProduitRepostry ;

	
	@Autowired
	StockRepostry StockRepostry ;
	
	
	
	@Override
	public List<Produit> retrieveAllProduit() {
		// TODO Auto-generated method stub
		
		System.out.println(ProduitRepostry.findAll());
		
		return (List<Produit>) ProduitRepostry.findAll();
	}

	
	@Transactional
	@Override
	public Produit addProduit(Produit p, Long idRayon , Long idStock){
		// TODO Auto-generated method stub
		p.setRayon(RayonRepostry.findById(idRayon).get());
		p.setStock(StockRepostry.findById(idStock).get());
		DetailProduit dp = saveDetailProduit(p);
		p.setDetailProduit(dp);
		 ProduitRepostry.save(p); 
		return p;
	}

	private DetailProduit saveDetailProduit(Produit p) {
		// TODO Auto-generated method stub
		if (p.getDetailProduit().getDateCreation()==null){
			p.getDetailProduit().setDateCreation(new Date());
			p.getDetailProduit().setdDerModification(new Date());
		}
		else{  p.getDetailProduit().setdDerModification(new Date());}
		
		DetailProduit dp = DetailProduitRepostry.save(p.getDetailProduit());
		
		return dp;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		ProduitRepostry.deleteById(id);
		
		
	}

	@Override
	public Produit UpdateProduit(Produit p) {
		// TODO Auto-generated method stub
		List<Produit> Produits = (List<Produit>) ProduitRepostry.save(p);
		return p;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Produit p ; 
		p= ProduitRepostry.findById(id).get();
		
		return p;
	}

}
