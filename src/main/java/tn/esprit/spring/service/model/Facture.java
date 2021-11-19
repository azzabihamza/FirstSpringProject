package tn.esprit.spring.service.model;


import lombok.Getter;
import lombok.Setter;
import tn.esprit.spring.DAO.DetailFacture;



import java.util.Date;
import java.util.Set;

@Setter
@Getter
public class Facture {

    private long idFacture;
    private float montantRemise;
    private float montantFacture;
    private Date dateFacture;
    private boolean active;
    private Client client;
    private Set<DetailFacture> detailfactures;

    public Facture(long idFacture, float montantRemise, float montantFacture, Date dateFacture, boolean active, Client client, Set<DetailFacture> detailfactures) {
        this.idFacture = idFacture;
        this.montantRemise = montantRemise;
        this.montantFacture = montantFacture;
        this.dateFacture = dateFacture;
        this.active = active;
        this.client = client;
        this.detailfactures = detailfactures;
    }

    public Facture() {
    }

    public long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(long idFacture) {
        this.idFacture = idFacture;
    }

    public float getMontantRemise() {
        return montantRemise;
    }

    public void setMontantRemise(float montantRemise) {
        this.montantRemise = montantRemise;
    }

    public float getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(float montantFacture) {
        this.montantFacture = montantFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<DetailFacture> getDetailfactures() {
        return detailfactures;
    }

    public void setDetailfactures(Set<DetailFacture> detailfactures) {
        this.detailfactures = detailfactures;
    }


}
