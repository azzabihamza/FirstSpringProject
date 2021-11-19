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
    public void cancelFacture(Facture facture) {
        FactureEntity factureEntity = FactureEntityMapper.mapFactureToFactureEntity(facture);
        factureRepository.updateActive(factureEntity.getIdFacture(),false);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return FactureEntityMapper.mapFactureEntityToFacture(factureRepository.retrieveFactureById(id));
    }

    @Override
    public void createFacture(Facture facture) {
        ClientEntity client= clientService.retrieveClient(facture.getClient().getIdClient());
        if (client != null) {
            FactureEntity factureEntity = FactureEntityMapper.mapFactureToFactureEntity(facture);
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
    public List<Facture> retrieveFacturesInActive() {
        return FactureEntityMapper.mapFactureEntityListToFactureList(factureRepository.retrieveAllInActiveFacture());
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
