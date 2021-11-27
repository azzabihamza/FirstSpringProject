package tn.esprit.spring.DAO.model;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.DAO.Produit;


@Getter
@Setter
public class DetailFacture {

    private long idDetailFacture;
    private int qte;
    private float prixTotal;
    private int pourcentageRemise;
    private int montantRemise;
    Produit produit;
    Facture facture;

    public DetailFacture() {
    }

    public DetailFacture(long idDetailFacture ,int qte, float prixTotal, int pourcentageRemise, int montantRemise, Produit produit, Facture facture) {
        this.idDetailFacture=idDetailFacture;
        this.qte = qte;
        this.prixTotal = prixTotal;
        this.pourcentageRemise = pourcentageRemise;
        this.montantRemise = montantRemise;
        this.produit = produit;
        this.facture = facture;
    }

}
