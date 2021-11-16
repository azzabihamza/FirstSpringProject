package tn.esprit.spring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.esprit.spring.DAO.Facture;
import tn.esprit.spring.repository.FactureRepository;

import java.util.List;

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

    @AfterEach
    void tearDown() {
    }

    @Test
    void testRetrieveAllFactures() {
    }

    @Test
    void testCancelFacture() {
    }

    @Test
    void testRetrieveFacture() {
    }

    @Test
    void createFacture() {
    }

    @Test
    void updateFacture() {
    }

    @Test
    void deleteFacture() {
    }


    @Test
    void retrieveFacturesByClientAndStatus() {
    }

    @Test
    void retrieveFacturesByClientAndStatusAndDate() {
    }

    @Test
    void retrieveFacturesByClientAndStatusAndDateAndType() {
    }
}