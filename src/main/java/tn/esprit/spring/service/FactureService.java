package tn.esprit.spring.service;

import tn.esprit.spring.DAO.Facture;

import java.util.List;

public interface FactureService {
    List<Facture> retrieveAllFactures();

    void cancelFacture(Long id);

    Facture retrieveFacture(Long id);

    void createFacture(Facture facture);

    void updateFacture(Facture facture);

    void deleteFacture(Long id);

    List<Facture> retrieveFacturesByClient(Long id);

    List<Facture> retrieveFacturesByClientAndStatus(Long id, String status);

    List<Facture> retrieveFacturesByClientAndStatusAndDate(Long id, String status, String date);

    List<Facture> retrieveFacturesByClientAndStatusAndDateAndType(Long id, String status, String date, String type);


}
