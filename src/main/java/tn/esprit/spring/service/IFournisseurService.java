package tn.esprit.spring.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.dao.entity.CategorieProduit;
import tn.esprit.spring.dao.entity.Fournisseur;


public interface IFournisseurService {
	public List <Fournisseur> retrieveAllFournisseur(); 
	public Fournisseur addFournisseur(Fournisseur p); 
	public void deleteFournisseur (Long id); 
	public Fournisseur UpdateFournisseur (Fournisseur F) ; 
	public Fournisseur retrieveFournisseur(Long id ); 
	public List<Fournisseur> retrieveClientsByCategorieProduit(CategorieProduit categorie_produit);
	public List<Fournisseur> retrieveClientsByDateCreation(String dateDebut,String dateFin );
	public int CountDistinctByCategorieProduit(@Param("cat") CategorieProduit categorie_produit);
	public int CountDistinctByCategorieProduitbydate(CategorieProduit categorie_produit,  String dateDebut, String dateFin );
	public int nombreTotalFournisseur();



}
