package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "profil_renumeration")
public class ProfilRemuneration {

	@Id
	private Integer id;
	
	private String code;

	@ManyToMany
	@JoinTable(name = "profil_cotisations_non_imposables",
		joinColumns = @JoinColumn(name = "profil_renumeration_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "cotisations_non_imposables_id", referencedColumnName = "id")
	)
	@Column(name = "cotisations_non_imposables")
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany
	@JoinTable(name = "profil_cotisations_imposables",
		joinColumns = @JoinColumn(name = "profil_renumeration_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "cotisations_imposables_id", referencedColumnName = "id")
	)
	@Column(name = "cotisation_imposables")
	private List<Cotisation> cotisationsImposables;
	
	@ManyToMany
	@JoinTable(name = "profil_avantages",
		joinColumns = @JoinColumn(name = "profil_renumeration_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "avantages_id", referencedColumnName = "id")
	)
	private List<Avantage> avantages;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
