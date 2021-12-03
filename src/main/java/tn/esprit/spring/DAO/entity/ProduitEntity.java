package tn.esprit.spring.DAO.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import tn.esprit.spring.DAO.Rayon;
import tn.esprit.spring.DAO.Stock;
import tn.esprit.spring.DAO.entity.FournisseurEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "Produit")
public class ProduitEntity implements Serializable {
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
	private Set<FournisseurEntity> fournisseurs;
	
	@OneToOne
	private DetailProduitEntity detailProduitEntity;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<DetailFactureEntity> detailFactures;

	
	

	public Set<FournisseurEntity> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(Set<FournisseurEntity> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public ProduitEntity() {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		ProduitEntity that = (ProduitEntity) o;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	public DetailProduitEntity getDetailProduitEntity() {
		return detailProduitEntity;
	}

	public void setDetailProduitEntity(DetailProduitEntity detailProduitEntity) {
		this.detailProduitEntity = detailProduitEntity;
	}

	public Set<DetailFactureEntity> getDetailFactures() {
		return detailFactures;
	}

	public void setDetailFactures(Set<DetailFactureEntity> detailFactures) {
		this.detailFactures = detailFactures;
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


	

}
