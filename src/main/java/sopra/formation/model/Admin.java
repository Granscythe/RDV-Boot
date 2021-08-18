package sopra.formation.model;

import javax.persistence.Entity;

@Entity
public class Admin  extends Personne{

	public Admin(Long id, int version, String nom, String prenom, String mail, String mdp) {
		super(id, version, nom, prenom, mail, mdp);
		// TODO Auto-generated constructor stub
	}

	public Admin() {
		super();
	}

	
}
