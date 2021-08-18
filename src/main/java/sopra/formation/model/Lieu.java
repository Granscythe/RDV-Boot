package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name = "Lieu")
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "TypeLieu")
	private String typeLieu ; 
	@Column(name = "Rue")
	private String rue ; 
	@Column(name = "Ville")
	private String ville ; 
	@Column(name = "CodePostal")
	private String codePostal ; 
	@Column(name = "Numero")
	private int numero ; 
	@OneToMany(mappedBy = "lieu")
	private List<CreneauPraticien> CreneauPraticiens = new ArrayList<CreneauPraticien>();
	@OneToMany(mappedBy = "lieu")
	private List<PraticienLieu> PraticienLieux = new ArrayList<PraticienLieu>();
	
	//Constructeurs
	public Lieu() {
		super();
	}

	public Lieu(String typeLieu, String rue, String ville, String codePostal, int numero) {
	
		this.typeLieu = typeLieu;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.numero = numero;
	}

	public Lieu(String typeLieu, String rue, String ville, String codePostal, int numero,
			List<CreneauPraticien> creneauPraticiens, List<PraticienLieu> praticienLieux) {
		super();
		this.typeLieu = typeLieu;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.numero = numero;
		CreneauPraticiens = creneauPraticiens;
		PraticienLieux = praticienLieux;
	}

	public Lieu(Long id, int version, String typeLieu, String rue, String ville, String codePostal, int numero,
			List<CreneauPraticien> creneauPraticiens, List<PraticienLieu> praticienLieux) {
		super();
		this.id = id;
		this.version = version;
		this.typeLieu = typeLieu;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.numero = numero;
		CreneauPraticiens = creneauPraticiens;
		PraticienLieux = praticienLieux;
	}
	
	
	// Getters & Setters 
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

	public String getTypeLieu() {
		return typeLieu;
	}

	public void setTypeLieu(String typeLieu) {
		this.typeLieu = typeLieu;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<CreneauPraticien> getCreneauPraticiens() {
		return CreneauPraticiens;
	}

	public void setCreneauPraticiens(List<CreneauPraticien> creneauPraticiens) {
		CreneauPraticiens = creneauPraticiens;
	}

	public List<PraticienLieu> getPraticienLieux() {
		return PraticienLieux;
	}

	public void setPraticienLieux(List<PraticienLieu> praticienLieux) {
		PraticienLieux = praticienLieux;
	}
	
	//To string
	@Override
	public String toString() {
		return "Lieu [id=" + id + ", version=" + version + ", typeLieu=" + typeLieu + ", rue=" + rue + ", ville="
				+ ville + ", codePostal=" + codePostal + ", numero=" + numero + "]";
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
