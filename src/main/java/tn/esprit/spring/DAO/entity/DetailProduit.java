package tn.esprit.spring.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table( name ="detailProd")
public class DetailProduit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDetailProduit")
	private long idDetailProduit; //clé primaire
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	private Date dDerModification;
	@Enumerated(EnumType.STRING)
	private CategorieProduit CategorieProduit;
	
	public long getIdDetailProduit() {
		return idDetailProduit;
	}
	public void setIdDetailProduit(long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getdDerModification() {
		return dDerModification;
	}
	public void setdDerModification(Date date) {
		this.dDerModification = date;
	}
	
	@OneToOne(mappedBy="detailProduit")
	private Produit produit ;

}
