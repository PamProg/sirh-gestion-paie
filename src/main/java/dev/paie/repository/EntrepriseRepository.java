package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Entreprise;

/**
 * Permet la persistence des Entreprise en base de données
 * @author ETY15
 *
 */
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer>{

	/**
	 * Renvoie l'Entreprise de nom denomination
	 * @param denomination le nom de l'Entreprise
	 * @return
	 */
	Entreprise findOneByDenomination(String denomination);
}
