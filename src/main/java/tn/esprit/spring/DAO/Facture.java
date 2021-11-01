package tn.esprit.spring.DAO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Facture")
public class Facture implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFacture;
	private float montantRemise;
	private float montantFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	private boolean active;
	@ManyToOne
	Client client;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "facture")
	private Set<DetailFacture> detailfactures;

	public Facture(long idFacture, float montantRemise, float montantFacture, Date dateFacture, boolean active,
			Client client, Set<DetailFacture> detailfactures) {
		super();
		this.idFacture = idFacture;
		this.montantRemise = montantRemise;
		this.montantFacture = montantFacture;
		this.dateFacture = dateFacture;
		this.active = active;
		this.client = client;
		this.detailfactures = detailfactures;
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
