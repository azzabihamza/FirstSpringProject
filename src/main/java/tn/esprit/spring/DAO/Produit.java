package tn.esprit.spring.DAO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prixUnitaire;
	@ManyToOne
	Stock stock;
	@ManyToOne
	Rayon rayon;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Fournisseur> fournisseurs;
	@OneToOne
	private DetailProduit detailProduit;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
	private Set<DetailFacture> detailFactures;

	public Produit(long idProduit, String codeProduit, String libelleProduit, float prixUnitaire, Stock stock,
			Rayon rayon, Set<Fournisseur> fournisseurs, DetailProduit detailProduit,
			Set<DetailFacture> detailFactures) {
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prixUnitaire = prixUnitaire;
		this.stock = stock;
		this.rayon = rayon;
		this.fournisseurs = fournisseurs;
		this.detailProduit = detailProduit;
		this.detailFactures = detailFactures;
	}

	public Set<DetailFacture> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(Set<DetailFacture> detailFactures) {
		this.detailFactures = detailFactures;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Rayon getRayon() {
		return rayon;
	}

	public void setRayon(Rayon rayon) {
		this.rayon = rayon;
	}

	public Set<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}

	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

}
