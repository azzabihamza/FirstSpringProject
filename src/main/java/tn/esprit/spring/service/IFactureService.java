package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entity.Facture;

public interface IFactureService {
	public List <Facture> retrieveAllFacture(); 
	public Facture addFacture(Facture F); 
	public void deleteFacture (Long id); 
	public Facture UpdateFacture (Facture F ) ; 
	public Facture retrieveFacture(Long id ); 

}
