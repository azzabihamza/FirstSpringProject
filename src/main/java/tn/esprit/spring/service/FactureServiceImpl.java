package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.ClientEntity;

import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.mapper.FactureEntityMapper;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.service.model.Facture;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    FactureRepository factureRepository;

    @Autowired
    ClientService clientService;

    @Override
    public List<Facture> retrieveAllFactures() {
        return FactureEntityMapper.mapFactureEntityListToFactureList(factureRepository.findAll());
    }

    @Override
    public void cancelFacture(Long id) {
        FactureEntity factureEntity = factureRepository.findById(id).orElse(null);
        if (factureEntity != null) {
            factureEntity.setActive(false);
        }
        factureRepository.save(factureEntity);
    }

    @Override
    public FactureEntity retrieveFacture(Long id) {
        FactureEntity factureEntity = factureRepository.findById(id).orElse(null);
        System.out.println("facture : "+ factureEntity);
        return factureEntity;
    }

    @Override
    public void createFacture(FactureEntity factureEntity, Long idClient) {
        ClientEntity client= clientService.retrieveClient(idClient);
        if (client != null) {
            factureEntity.setClient(client);
            factureRepository.save(factureEntity);
        }else
            System.out.println("client not found");
    }

    @Override
    public void updateFacture(FactureEntity factureEntity) {
        factureRepository.save(factureEntity);
    }

    @Override
    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public List<FactureEntity> retrieveFacturesInActive() {
        List<FactureEntity> factureEntities = factureRepository.retrieveAllInActiveFacture();
        for (FactureEntity factureEntity : factureEntities)
            System.out.println("facture : "+ factureEntity);
        return factureEntities;
    }

    @Override
    public List<FactureEntity> retrieveFacturesActive() {
        List<FactureEntity> factureEntities = factureRepository.retrieveAllActiveFacture();
        for (FactureEntity factureEntity : factureEntities)
            System.out.println("facture : "+ factureEntity);
        return factureEntities;
    }

    @Override
    public List<FactureEntity> retrieveFacturesByPriceRange(double min, double max) {
        return factureRepository.retrieveAllFactureByTTCRange(min,max);
    }

    @Override
    public List<FactureEntity> retrieveFacturesByDateRange(String date1, String date2) {
        return factureRepository.retirveAllFactureBetweenDate(date1,date2);
    }

    @Override
    public List<FactureEntity> retrieveFacturesByDate(String date) {
        return factureRepository.retrieveAllFactureByDate(date);
    }

    @Override
    public List<FactureEntity> retrieveFacturesByStatusAndDate(String status, String date) {
        if (status.equals("true"))
            return factureRepository.retrieveAllFactureByDateAndActive(date);
        else
            return factureRepository.retrieveAllFactureByDateAndInActive(date);
    }

    @Override
    public FactureEntity assignClientToFacture(FactureEntity factureEntity, Long id) {
        /*Client client= clientService.retrieveClient(id);
        if (client != null) {
            facture.setClient(client);
            return facture;
        }else
            System.out.println("client not found");*/
        return null;
    }
}
