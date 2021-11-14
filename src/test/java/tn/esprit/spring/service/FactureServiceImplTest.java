package tn.esprit.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.DAO.Facture;
import tn.esprit.spring.repository.FactureRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FactureServiceImplTest {

    @Autowired
    FactureRepository factureRepository;

    @Test
    void retrieveAllFactures() {
        List<Facture> factures = (List<Facture>) factureRepository.findAll();
        for (Facture facture : factures)
            System.out.println(facture);
    }

    @Test
    void cancelFacture() {
    }

    @Test
    void retrieveFacture() {
    }
}