package dev.paie.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	
	@Id @ GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nom_service")
	private String nomService;
	@Column(name = "date_heure")
	private LocalDateTime dateHeure;
	@Column(name = "temps_execution")
	private Long tempsExecution;
	
	/**
	 * 
	 */
	public Performance() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nomService
	 * @param dateHeure
	 * @param tempsExecution
	 */
	public Performance(String nomService, LocalDateTime dateHeure, Long tempsExecution) {
		this.nomService = nomService;
		this.dateHeure = dateHeure;
		this.tempsExecution = tempsExecution;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nomService
	 */
	public String getNomService() {
		return nomService;
	}

	/**
	 * @param nomService the nomService to set
	 */
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	/**
	 * @return the dateHeure
	 */
	public LocalDateTime getDateHeure() {
		return dateHeure;
	}

	/**
	 * @param dateHeure the dateHeure to set
	 */
	public void setDateHeure(LocalDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	/**
	 * @return the tempsExecution
	 */
	public Long getTempsExecution() {
		return tempsExecution;
	}

	/**
	 * @param tempsExecution the tempsExecution to set
	 */
	public void setTempsExecution(Long tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	
}
