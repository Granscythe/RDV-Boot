package sopra.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Motif")
public class Motif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	private String intitule;
	private Integer duree;
	@OneToMany(mappedBy="motif")
	private List<RDV> rdv;
	@ManyToOne
	@JoinColumn(name="praticien")
	private Praticien praticien;
	
	public Motif() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motif(Long id, String intitule, Integer duree, List<RDV> rdv, Praticien praticien) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.duree = duree;
		this.rdv = rdv;
		this.praticien = praticien;
	}

	public Motif(String intitule, Integer duree, List<RDV> rdv, Praticien praticien) {
		super();
		this.intitule = intitule;
		this.duree = duree;
		this.rdv = rdv;
		this.praticien = praticien;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public List<RDV> getRdv() {
		return rdv;
	}

	public void setRdv(List<RDV> rdv) {
		this.rdv = rdv;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}
	
	
	
}
