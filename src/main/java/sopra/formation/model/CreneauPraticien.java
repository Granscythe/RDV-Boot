package sopra.formation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class CreneauPraticien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Version
	private int version;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateDeDebutPraticien")
	private Date dtDebutPraticien;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DateDeFinPraticien")
	private Date dtFinPraticien;
	
	@ManyToOne
	@JoinColumn(name="Lieu")
	private Lieu lieu;

	
	@ManyToOne
	@JoinColumn(name="Praticien")
	private Praticien praticien;
	
	@OneToMany(mappedBy = "creneauPraticien")
	private List<CreneauUnitaire> creneauUnitaire;

	
	public CreneauPraticien() {
		super();
	}


	public CreneauPraticien(Long id, int version, Date dtDebutPraticien, Date dtFinPraticien, Lieu lieu,
			Praticien praticien, List<CreneauUnitaire> creneauUnitaire) {
		this.id = id;
		this.version = version;
		this.dtDebutPraticien = dtDebutPraticien;
		this.dtFinPraticien = dtFinPraticien;
		this.lieu = lieu;
		this.praticien = praticien;
		this.creneauUnitaire = creneauUnitaire;
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


	public Date getDtDebutPraticien() {
		return dtDebutPraticien;
	}


	public void setDtDebutPraticien(Date dtDebutPraticien) {
		this.dtDebutPraticien = dtDebutPraticien;
	}


	public Date getDtFinPraticien() {
		return dtFinPraticien;
	}


	public void setDtFinPraticien(Date dtFinPraticien) {
		this.dtFinPraticien = dtFinPraticien;
	}


	public Lieu getLieu() {
		return lieu;
	}


	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}


	public Praticien getPraticien() {
		return praticien;
	}


	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}


	public List<CreneauUnitaire> getCreneauUnitaire() {
		return creneauUnitaire;
	}


	public void setCreneauUnitaire(List<CreneauUnitaire> creneauUnitaire) {
		this.creneauUnitaire = creneauUnitaire;
	}


	@Override
	public String toString() {
		return "CreneauPraticien [id=" + id + ", version=" + version + ", dtDebutPraticien=" + dtDebutPraticien
				+ ", dtFinPraticien=" + dtFinPraticien + ", lieu=" + lieu + ", praticien=" + praticien
				+ ", creneauUnitaire=" + creneauUnitaire + "]";
	}
	
}
