package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.entity.ProduitEntity;

public interface ProduitService {

	List<ProduitEntity> retrieveAllProduits();

	public void addProduit(ProduitEntity p);

	ProduitEntity retrieveProduit(Long id);

	public void deleteProduit (Long id);

    public void updateProduit(ProduitEntity p);

    public List<ProduitEntity> retrieveProduitsByRayon(Long idRayon);

    public List<ProduitEntity> retrieveProduitsByStock(Long idStock);

    public List<ProduitEntity> retrieveProduitsByRayonAndStock(Long idRayon, Long idStock);

}
