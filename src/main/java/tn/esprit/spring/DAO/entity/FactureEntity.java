package tn.esprit.spring.DAO.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Facture")
@Getter
@Setter
public class FactureEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private boolean active;
	@JsonBackReference
	@ManyToOne
	private ClientEntity client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "factureEntity")
	private Set<DetailFactureEntity> detailfactures;

	public FactureEntity(long idFacture, float montantRemise, float montantFacture, Date dateFacture, boolean active,
						 ClientEntity client, Set<DetailFactureEntity> detailfactures) {
		super();
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
		this.client = client;
		this.detailfactures = detailfactures;
	}

	public FactureEntity() {

	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}

	public Set<DetailFactureEntity> getDetailfactures() {
		return detailfactures;
	}

	public void setDetailfactures(Set<DetailFactureEntity> detailfactures) {
		this.detailfactures = detailfactures;
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

}
