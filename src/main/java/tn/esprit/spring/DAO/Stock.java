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
@Table(name = "Stock")
public class Stock implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idStock;
	private int qteStock;
	private int qteMin;
	private String libelleStock;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "stock")
	private Set<Produit> produits;

	public Stock(long idStock, int qteStock, int qteMin, String libelleStock, Set<Produit> produits) {
		super();
		this.idStock = idStock;
		this.qteStock = qteStock;
		this.qteMin = qteMin;
		this.libelleStock = libelleStock;
		this.produits = produits;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	public long getIdStock() {
		return idStock;
	}

	public void setIdStock(long idStock) {
		this.idStock = idStock;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public int getQteMin() {
		return qteMin;
	}

	public void setQteMin(int qteMin) {
		this.qteMin = qteMin;
	}

	public String getLibelleStock() {
		return libelleStock;
	}

	public void setLibelleStock(String libelleStock) {
		this.libelleStock = libelleStock;
	}

}
