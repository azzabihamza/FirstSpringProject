package tn.esprit.spring.dao.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table( name ="Produit")
public class Produit implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private Long idProduit; //clé primaire
	private String code;
	private String libelle;
	private float prixUnitaire;
	//les constructeurs & les getters et les setters 
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
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

	@OneToOne
	private DetailProduit detailProduit; 
	
	@ManyToOne
	Stock stock;

	@ManyToOne
	Rayon rayon;
	
	@ManyToMany
	private Set<Fournisseur> fournisseurs;
	
	@OneToMany(mappedBy="produit")
	private Set<DetailFacture> DetailFactures;
	public DetailProduit getDetailProduit() {
		return detailProduit;
	}
	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	} 
	
}
