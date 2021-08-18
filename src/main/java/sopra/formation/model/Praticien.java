package sopra.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Praticien extends Personne{
	@OneToMany(mappedBy = "praticien")
	private List<Motif> motifs;
			
	@OneToMany(mappedBy = "praticien")
	private List<RDV> rdvs;
	
	@OneToMany(mappedBy = "praticien")
	private List<CreneauPraticien> creneauPraticien;
	
	@OneToMany(mappedBy = "praticien")
	private List<PraticienLieu> praticienLieu;
	@OneToMany(mappedBy = "praticien")
	private List<SpecialitePraticien> specialite;

	public Praticien() {
		super();
		
	}

	public Praticien(Long id, int version, String mail, String mdp) {
		super(id, version, mail, mdp);
		
	}



	public Praticien(List<Motif> motifs, List<RDV> rdvs, List<CreneauPraticien> creneauPraticien,
			List<PraticienLieu> praticienLieu, List<SpecialitePraticien> specialite) {
		super();
		this.motifs = motifs;
		this.rdvs = rdvs;
		this.creneauPraticien = creneauPraticien;
		this.praticienLieu = praticienLieu;
		this.specialite = specialite;
	}

	
	public List<SpecialitePraticien> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(List<SpecialitePraticien> specialite) {
		this.specialite = specialite;
	}

	public List<Motif> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}

	public List<RDV> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<RDV> rdvs) {
		this.rdvs = rdvs;
	}

	public List<CreneauPraticien> getCreneauPraticien() {
		return creneauPraticien;
	}

	public void setCreneauPraticien(List<CreneauPraticien> creneauPraticien) {
		this.creneauPraticien = creneauPraticien;
	}

	public List<PraticienLieu> getPraticienLieu() {
		return praticienLieu;
	}

	public void setPraticienLieu(List<PraticienLieu> praticienLieu) {
		this.praticienLieu = praticienLieu;
	}

	@Override
	public String toString() {
		return "Praticien [motifs=" + motifs + ", rdvs=" + rdvs + "]";
	}

	
		
}
