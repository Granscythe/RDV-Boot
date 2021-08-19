package sopra.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class PraticienLieu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "lieu_id")
	@JsonView(Views.ViewPraticienLieu.class)
    private Lieu lieu;
    @ManyToOne
    @JoinColumn(name = "praticien_id")
    @JsonView(Views.ViewPraticienLieu.class)
    private Praticien praticien;
	
    
    // Constructeurs
	public PraticienLieu() {
		super();
	}


	public PraticienLieu(Long id, Lieu lieu, Praticien praticien) {
		super();
		this.id = id;
		this.lieu = lieu;
		this.praticien = praticien;
	}

   
	//Getters & Setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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



	//To string 
	@Override
	public String toString() {
		return "PraticienLieu [id=" + id + ", lieu=" + lieu + "]";
	}
	
    
	
	
    
	

}

	