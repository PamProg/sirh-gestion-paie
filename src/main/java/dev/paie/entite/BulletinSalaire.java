package dev.paie.entite;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Table BulletinSalaire
 * Correspond au bulletin d'un RemunerationEmploye (ie un employé)
 * @author ETY15
 *
 */
@Entity(name = "bulletin_salaire")
public class BulletinSalaire {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne @JoinColumn(name = "remuneration_id")
	private RemunerationEmploye remunerationEmploye;
	
	@ManyToOne @JoinColumn(name = "periode_id")
	private Periode periode;
	
	@Column(name = "prime_exceptionnelle")
	private BigDecimal primeExceptionnelle;
	
	@Column(name = "date_heure_creation")
	private LocalDateTime dateHeureCreation;
	
	public BulletinSalaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BulletinSalaire(RemunerationEmploye remunerationEmploye, Periode periode, BigDecimal primeExceptionnelle,
			LocalDateTime dateHeureCreation) {
		super();
		this.remunerationEmploye = remunerationEmploye;
		this.periode = periode;
		this.primeExceptionnelle = primeExceptionnelle;
		this.dateHeureCreation = dateHeureCreation;
	}

	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}
	public Periode getPeriode() {
		return periode;
	}
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
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

	public void setDateHeureCreation(LocalDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	
	
	
}
