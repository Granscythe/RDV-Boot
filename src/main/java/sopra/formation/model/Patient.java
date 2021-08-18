package sopra.formation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Patient extends Personne{
	String numSecuriteSociale;
	@OneToMany(mappedBy="patient")
	private List<RDV> rdvs;

	public Patient(Long id, int version, String nom, String prenom, String mail, String mdp, String numSecuriteSociale,
			List<RDV> rdvs) {
		super(id, version, nom, prenom, mail, mdp);
		this.numSecuriteSociale = numSecuriteSociale;
		this.rdvs = rdvs;
	}


	public Patient(Long id, int version, String nom, String prenom, String mail, String mdp) {
		super(id, version, nom, prenom, mail, mdp);
		// TODO Auto-generated constructor stub
	}


	public String getNumSecuriteSociale() {
		return numSecuriteSociale;
	}

	public void setNumSecuriteSociale(String numSecuriteSociale) {
		this.numSecuriteSociale = numSecuriteSociale;
	}

	public List<RDV> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<RDV> rdvs) {
		this.rdvs = rdvs;
	}

	
}
