package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entity.Rayon;

public interface IRayonService {
	public List <Rayon> retrieveAllRayon(); 
	public Rayon addRayon(Rayon R); 
	public void deleteRayon (Long id); 
	public Rayon UpdateRayon (Rayon R ) ; 
	public Rayon retrieveRayon(Long id ); 

}
