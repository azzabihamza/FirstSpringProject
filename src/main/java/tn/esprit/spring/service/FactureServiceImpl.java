package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.Facture;
import tn.esprit.spring.repostry.*;


@Service
public class FactureServiceImpl implements IFactureService {

	@Autowired
	FactureRepostry FactureRepostry ;
	
	
	@Override
	public List<Facture> retrieveAllFacture() {
		// TODO Auto-generated method stub
		System.out.println(FactureRepostry.findAll());
		
		return (List<Facture>) FactureRepostry.findAll();
	
	}

	@Override
	public Facture addFacture(Facture F) {
		// TODO Auto-generated method stub
		 FactureRepostry.save(F); 
			return F;

	}

	@Override
	public void deleteFacture(Long id) {
		// TODO Auto-generated method stub
		FactureRepostry.deleteById(id);

		
	}

	@Override
	public Facture UpdateFacture(Facture F) {
		// TODO Auto-generated method stub
		List<Facture> Facture = (List<Facture>) FactureRepostry.save(F);
		return F;	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		Facture F ; 
		F= FactureRepostry.findById(id).get();
		
		return F;}

}
