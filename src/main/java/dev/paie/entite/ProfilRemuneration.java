package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Table profil_remuneration.
 * Correspond à un profil d'un employé et contenant une liste
 * d'avantages et/ou de cotisations
 * @author ETY15
 *
 */
@Entity(name = "profil_renumeration")
public class ProfilRemuneration {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	
	// https://stackoverflow.com/questions/22821695/lazyinitializationexception-failed-to-lazily-initialize-a-collection-of-roles
	// https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api
//	@ManyToMany(fetch = FetchType.EAGER)
	// https://stackoverflow.com/questions/4334970/hibernate-cannot-simultaneously-fetch-multiple-bags
	@ManyToMany
//	@LazyCollection(LazyCollectionOption.FALSE) Mauvaise pratique car ralenti beaucoup trop l'appli
	@JoinTable(name = "profil_cotisations_non_imposables",
		joinColumns = @JoinColumn(name = "profil_renumeration_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "cotisations_non_imposables_id", referencedColumnName = "id")
	)
	@Column(name = "cotisations_non_imposables")
	private List<Cotisation> cotisationsNonImposables;
	
	@ManyToMany
//	@LazyCollection(LazyCollectionOption.FALSE) Mauvaise pratique car ralenti beaucoup trop l'appli
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
