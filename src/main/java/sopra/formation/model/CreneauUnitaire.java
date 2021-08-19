package sopra.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class CreneauUnitaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateDeDebutUnitaire")
	@JsonView(Views.ViewCommon.class)
//	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dtDebutUnitaire;
	
	@Column(name = "Duree")
	@JsonView(Views.ViewCommon.class)
	private Integer duree;
	
	@Column(name = "Statut")
	@JsonView(Views.ViewCommon.class)
	private boolean statut;
	
	@ManyToOne
	@JoinColumn(name="RDV")
	private RDV rdv;
	
	@ManyToOne
	@JoinColumn(name="CreneauPraticien")
	private CreneauPraticien creneauPraticien;
	

	public CreneauUnitaire() {
		super();
	}


	public CreneauUnitaire(Long id, int version, Date dtDebutUnitaire, Integer duree, boolean statut, RDV rdv,
			CreneauPraticien creneauPraticien) {
		this.id = id;
		this.version = version;
		this.dtDebutUnitaire = dtDebutUnitaire;
		this.duree = duree;
		this.statut = statut;
		this.rdv = rdv;
		this.creneauPraticien = creneauPraticien;
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


	public Date getDtDebutUnitaire() {
		return dtDebutUnitaire;
	}


	public void setDtDebutUnitaire(Date dtDebutUnitaire) {
		this.dtDebutUnitaire = dtDebutUnitaire;
	}


	public Integer getDuree() {
		return duree;
	}


	public void setDuree(Integer duree) {
		this.duree = duree;
	}


	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}


	public RDV getRdv() {
		return rdv;
	}


	public void setRdv(RDV rdv) {
		this.rdv = rdv;
	}


	public CreneauPraticien getCreneauPraticien() {
		return creneauPraticien;
	}


	public void setCreneauPraticien(CreneauPraticien creneauPraticien) {
		this.creneauPraticien = creneauPraticien;
	}


	@Override
	public String toString() {
		return "CreneauUnitaire [id=" + id + ", version=" + version + ", dtDebutUnitaire=" + dtDebutUnitaire
				+ ", duree=" + duree + ", statut=" + statut + ", creneauPraticien=" + creneauPraticien + "]";
	}

	
	
}
