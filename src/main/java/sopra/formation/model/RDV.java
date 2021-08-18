package sopra.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="RDV")
public class RDV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Statut statut;
	@ManyToOne
	@JoinColumn(name="motifRDV")
	@JsonView(Views.ViewRDV.class)
	private Motif motif;
	@ManyToOne
	@JoinColumn(name="patient")
	@JsonView(Views.ViewRDV.class)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="praticien")
	@JsonView(Views.ViewRDV.class)
	private Praticien praticien;
	@OneToMany(mappedBy = "rdv")
	@JsonView(Views.ViewRDV.class)
	private List<CreneauUnitaire> creneaux;
	
	
	public RDV() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RDV(Long id, Statut statut, Motif motif, Patient patient, Praticien praticien,
			List<CreneauUnitaire> creneaux) {
		super();
		this.id = id;
		this.statut = statut;
		this.motif = motif;
		this.patient = patient;
		this.praticien = praticien;
		this.creneaux = creneaux;
	}


	public RDV(Statut statut, Motif motif, Patient patient, Praticien praticien, List<CreneauUnitaire> creneaux) {
		super();
		this.statut = statut;
		this.motif = motif;
		this.patient = patient;
		this.praticien = praticien;
		this.creneaux = creneaux;
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


	public Statut getStatut() {
		return statut;
	}


	public void setStatut(Statut statut) {
		this.statut = statut;
	}


	public Motif getMotif() {
		return motif;
	}


	public void setMotif(Motif motif) {
		this.motif = motif;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Praticien getPraticien() {
		return praticien;
	}


	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}


	public List<CreneauUnitaire> getCreneaux() {
		return creneaux;
	}


	public void setCreneaux(List<CreneauUnitaire> creneaux) {
		this.creneaux = creneaux;
	}


	

}
