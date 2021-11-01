package tn.esprit.spring.DAO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rayon")
public class Rayon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRayon;
	private String codeRayon;
	private String libelleRayon;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rayon")
	private Set<Produit> produits;

	public Rayon(long idRayon, String codeRayon, String libelleRayon, Set<Produit> produits) {
		super();
		this.idRayon = idRayon;
		this.codeRayon = codeRayon;
		this.libelleRayon = libelleRayon;
		this.produits = produits;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public long getIdRayon() {
		return idRayon;
	}

	public void setIdRayon(long idRayon) {
		this.idRayon = idRayon;
	}

	public String getCodeRayon() {
		return codeRayon;
	}

	public void setCodeRayon(String codeRayon) {
		this.codeRayon = codeRayon;
	}

	public String getLibelleRayon() {
		return libelleRayon;
	}

	public void setLibelleRayon(String libelleRayon) {
		this.libelleRayon = libelleRayon;
	}

}
