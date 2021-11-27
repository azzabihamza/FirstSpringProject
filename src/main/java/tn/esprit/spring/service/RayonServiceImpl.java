package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.Rayon;
import tn.esprit.spring.repostry.*;


@Service
public class RayonServiceImpl implements IRayonService {

	@Autowired
	RayonRepostry RayonRepostry ;
	
	@Override
	public List<Rayon> retrieveAllRayon() {
		// TODO Auto-generated method stub
		System.out.println(RayonRepostry.findAll());
		
		return (List<Rayon>) RayonRepostry.findAll();
	
	}

	@Override
	public Rayon addRayon(Rayon R) {
		// TODO Auto-generated method stub
		 RayonRepostry.save(R); 
			return R;
}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		RayonRepostry.deleteById(id);

		
	}

	@Override
	public Rayon UpdateRayon(Rayon R) {
		// TODO Auto-generated method stub
		List<Rayon> Rayons = (List<Rayon>) RayonRepostry.save(R);
		return R;	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		Rayon R ; 
		R= RayonRepostry.findById(id).get();
		
		return R;}

}
