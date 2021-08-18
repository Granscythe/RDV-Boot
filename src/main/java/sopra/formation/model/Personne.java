package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	@Version
	private int version;
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String mdp;
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Personne(Long id, int version, String mail, String mdp) {
		super();
		this.id = id;
		this.version = version;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Personne(Long id, int version, String nom, String prenom, String mail, String mdp) {
		super();
		this.id = id;
		this.version = version;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
