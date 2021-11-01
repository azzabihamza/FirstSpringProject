package tn.esprit.spring.DAO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetailFacture")
public class DetailFacture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDetailFacture;
	private int qte;
	private float prixTotal;
	private int pourcentageRemise;
	private int montantRemise;
	@ManyToOne
	Produit produit;
	@ManyToOne
	Facture facture;

	public DetailFacture(long idDetailFacture, int qte, float prixTotal, int pourcentageRemise, int montantRemise,
			Produit produit, Facture facture) {
		super();
		this.idDetailFacture = idDetailFacture;
		this.qte = qte;
		this.prixTotal = prixTotal;
		this.pourcentageRemise = pourcentageRemise;
		this.montantRemise = montantRemise;
		this.produit = produit;
		this.facture = facture;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public int getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(int pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public int getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(int montantRemise) {
		this.montantRemise = montantRemise;
	}

}
