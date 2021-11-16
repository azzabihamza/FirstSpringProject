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

    List<Facture> retrieveFacturesByStatus(String status);

    List<Facture> retrieveFacturesByStatusAndDate(String status, String date);



}
