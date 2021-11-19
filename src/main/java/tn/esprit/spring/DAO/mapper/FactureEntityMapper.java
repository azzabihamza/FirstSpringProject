package tn.esprit.spring.DAO.mapper;


import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.service.model.CategorieClient;
import tn.esprit.spring.service.model.Client;
import tn.esprit.spring.service.model.Facture;
import tn.esprit.spring.service.model.Profession;

import java.util.ArrayList;
import java.util.List;

public class FactureEntityMapper {
   public static Facture mapFactureEntityToFacture(FactureEntity factureEntity) {
        return new Facture(factureEntity.getIdFacture(), factureEntity.getMontantRemise(),factureEntity.getMontantFacture(),factureEntity.getDateFacture(),factureEntity.isActive(),getClient(factureEntity.getClient()) ,factureEntity.getDetailfactures());
    }

    public static List<Facture> mapFactureEntityListToFactureList(List<FactureEntity> factureEntityList) {
       List<Facture> factures = new ArrayList<>();
        for (FactureEntity factureEntity : factureEntityList) {
           factures.add(new Facture(factureEntity.getIdFacture(), factureEntity.getMontantRemise(),factureEntity.getMontantFacture(),factureEntity.getDateFacture(),factureEntity.isActive(), getClient(factureEntity.getClient()),factureEntity.getDetailfactures()));
        }
        return factures;

    }

    private static Client getClient(ClientEntity clientEntity) {
        return new Client(clientEntity.getIdClient(),clientEntity.getNom(), clientEntity.getPrenom(), clientEntity.getEmail(), clientEntity.getPassword() ,clientEntity.getDateNaissance(), Profession.valueOf(clientEntity.getProfession().toString()) , CategorieClient.valueOf(clientEntity.getCategorieClient().toString()));
    }
}
