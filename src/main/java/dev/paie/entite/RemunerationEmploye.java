package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Table remuneration_employe
 * Correspond à un employé
 * @author ETY15
 *
 */
@Entity(name = "remuneration_employe")
public class RemunerationEmploye {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String matricule;
	
	@ManyToOne @JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	
	@ManyToOne @JoinColumn(name = "profil_id")
	private ProfilRemuneration profilRemuneration;
	
	@ManyToOne @JoinColumn(name = "grade_id")
	private Grade grade;
	
	@Column(name = "date_heure_creation")
	private LocalDateTime dateHeureCreation;
	
	/**
	 * 
	 */
	public RemunerationEmploye() {
		super();
	}

	public RemunerationEmploye(String matricule, Entreprise entreprise, ProfilRemuneration profilRemuneration,
			Grade grade, LocalDateTime dateHeureCreation) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRemuneration = profilRemuneration;
		this.grade = grade;
		this.dateHeureCreation = dateHeureCreation;
	}


	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	
	
	
	

}
