package tn.esprit.spring.dao.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table( name ="Rayon")
public class Rayon  implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idRayon")
	private long idRayon; //clé primaire
	private String codeRayon;
	private String libelleRayon;
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
	
	@OneToMany(mappedBy="rayon")
	private Set<Produit> prpduits;
	

}
