package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Client;
import tn.esprit.spring.DAO.Facture;
import tn.esprit.spring.repository.FactureRepository;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    ClientService clientService;

    @Override
    public List<Facture> retrieveAllFactures() {
        List<Facture> factures = (List<Facture>) factureRepository.findAll();
        for (Facture facture : factures)
            System.out.println("facture : "+ facture);
        return factures;
    }

    @Override
    public void cancelFacture(Long id) {
        Facture facture = factureRepository.findById(id).orElse(null);
        if (facture != null) {
            facture.setActive(false);
        }
        factureRepository.save(facture);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        Facture facture = factureRepository.findById(id).orElse(null);
        System.out.println("facture : "+facture);
        return facture;
    }

    @Override
    public void createFacture(Facture facture,Long idClient) {
        Client client= clientService.retrieveClient(idClient);
        if (client != null) {
            facture.setClient(client);
            factureRepository.save(facture);
        }else
            System.out.println("client not found");
    }

    @Override
    public void updateFacture(Facture facture) {
        factureRepository.save(facture);
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public List<Facture> retrieveFacturesInActive() {
        List<Facture> factures = factureRepository.retrieveAllInActiveFacture();
        for (Facture facture : factures)
            System.out.println("facture : "+ facture);
        return factures;
    }

    @Override
    public List<Facture> retrieveFacturesActive() {
        List<Facture> factures = factureRepository.retrieveAllActiveFacture();
        for (Facture facture : factures)
            System.out.println("facture : "+ facture);
        return factures;
    }

    @Override
    public List<Facture> retrieveFacturesByPriceRange(double min, double max) {
        return factureRepository.retrieveAllFactureByTTCRange(min,max);
    }

    @Override
    public List<Facture> retrieveFacturesByDateRange(String date1, String date2) {
        return factureRepository.retirveAllFactureBetweenDate(date1,date2);
    }

    @Override
    public List<Facture> retrieveFacturesByDate(String date) {
        return factureRepository.retrieveAllFactureByDate(date);
    }

    @Override
    public List<Facture> retrieveFacturesByStatusAndDate(String status, String date) {
        if (status.equals("true"))
            return factureRepository.retrieveAllFactureByDateAndActive(date);
        else
            return factureRepository.retrieveAllFactureByDateAndInActive(date);
    }

    @Override
    public Facture assignClientToFacture(Facture facture,Long id) {
        /*Client client= clientService.retrieveClient(id);
        if (client != null) {
            facture.setClient(client);
            return facture;
        }else
            System.out.println("client not found");*/
        return null;
    }
}
