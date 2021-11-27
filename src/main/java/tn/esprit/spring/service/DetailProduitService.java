package tn.esprit.spring.service;

import tn.esprit.spring.DAO.entity.DetailProduitEntity;

import java.util.List;

public interface DetailProduitService {

    List<DetailProduitEntity> retrieveAllDetailProduits();

    public void addDetailProduit(DetailProduitEntity detailProduit);

    public void deleteDetailProduit(long id);

    public DetailProduitEntity retrieveDetailProduit(long id);

    public void updateDetailProduit(DetailProduitEntity detailProduit);



}
