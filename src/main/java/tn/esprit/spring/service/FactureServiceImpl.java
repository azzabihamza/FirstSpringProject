package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.Facture;
import tn.esprit.spring.repository.FactureRepository;

import java.util.List;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    FactureRepository factureRepository;

    @Override
    public List<Facture> retrieveAllFactures() {
        return null;
    }

    @Override
    public void cancelFacture(Long id) {

    }

    @Override
    public Facture retrieveFacture(Long id) {
        return null;
    }
}
