package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.CategorieProduit;
import tn.esprit.spring.dao.entity.Client;
import tn.esprit.spring.dao.entity.Fournisseur;
import tn.esprit.spring.repostry.*;

@Service
public class FournisseurServiceImpl implements IFournisseurService {

	@Autowired
	FournisseurRepostry FournisseurRepostry ; 
	
	@Override
	public List<Fournisseur> retrieveAllFournisseur() {
		// TODO Auto-generated method stub
		System.out.println(FournisseurRepostry.findAll());
		
		return (List<Fournisseur>) FournisseurRepostry.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur p) {
		// TODO Auto-generated method stub
		List<Fournisseur> fournisseur = new ArrayList<Fournisseur>();
		fournisseur.add(FournisseurRepostry.save(p));
		return p;
	}

	@Override
	public void deleteFournisseur(Long id) {
		// TODO Auto-generated method stub
		FournisseurRepostry.deleteById(id);
	}

	@Override
	public Fournisseur UpdateFournisseur(Fournisseur f) {
		Fournisseur a = FournisseurRepostry.findById(f.getIdFournisseur()).get();
		a.setCodeFournisseur(f.getCodeFournisseur());
		a.setLibelleFournisseur(f.getLibelleFournisseur());
		a.setCategorieProduit(f.getCategorieProduit());
		a.setAdresseFournisseur(f.getAdresseFournisseur());
		a.setDateCreation(f.getDateCreation());
		a.setNumtel(f.getNumtel());
	
		return FournisseurRepostry.save(a);
	}
	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		// TODO Auto-generated method stub
		return FournisseurRepostry.findById(id).get();
	}

	
	@Override
	public List<Fournisseur> retrieveClientsByCategorieProduit(CategorieProduit categorie_produit) {
		// TODO Auto-generated method stub
		
		return FournisseurRepostry.retrieveClientsByCategorieProduit(categorie_produit);
	}

	@Override
	public List<Fournisseur> retrieveClientsByDateCreation(String dateDebut, String dateFin) {
		// TODO Auto-generated method stub
		return FournisseurRepostry.retrieveClientsByDateCreation(dateDebut, dateFin);
	}

	@Override
	public int CountDistinctByCategorieProduit(CategorieProduit categorie_produit) {
		// TODO Auto-generated method stub
		return FournisseurRepostry.CountDistinctByCategorieProduit(categorie_produit);
	}

	@Override
	public int CountDistinctByCategorieProduitbydate(CategorieProduit categorie_produit, String dateDebut, String dateFin) {
		// TODO Auto-generated method stub
		return FournisseurRepostry.CountDistinctByCategorieProduitbydate(categorie_produit, dateDebut, dateFin);
	}

	@Override
	public int nombreTotalFournisseur() {
		// TODO Auto-generated method stub
		return FournisseurRepostry.nombreTotalFournisseur();
	}
	

}
