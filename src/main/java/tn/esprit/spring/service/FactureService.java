package tn.esprit.spring.service;

import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.service.model.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> retrieveAllFactures();

    void cancelFacture(Facture facture);

    Facture retrieveFacture(Long id);

    void createFacture(Facture facture);

    void updateFacture(FactureEntity factureEntity);

    void deleteFacture(Long id);

    List<FactureEntity> retrieveFacturesInActive();

    List<FactureEntity> retrieveFacturesActive();

    List<FactureEntity> retrieveFacturesByPriceRange(double min, double max);

    List<FactureEntity> retrieveFacturesByDateRange(String date1, String date2);

    List<FactureEntity> retrieveFacturesByDate(String date);

    List<FactureEntity> retrieveFacturesByStatusAndDate(String status, String date);

    FactureEntity assignClientToFacture(FactureEntity factureEntity, Long id);


}
