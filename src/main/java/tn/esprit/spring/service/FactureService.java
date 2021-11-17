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

    List<Facture> retrieveFacturesInActive();

    List<Facture> retrieveFacturesActive();

    List<Facture> retrieveFacturesByPriceRange(double min, double max);

    List<Facture> retrieveFacturesByDateRange(String date1, String date2);

    List<Facture> retrieveFacturesByDate(String date);

    List<Facture> retrieveFacturesByStatusAndDate(String status, String date);




}
