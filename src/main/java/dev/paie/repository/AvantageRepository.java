package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Avantage;

/**
 * Permet la persistence des Avantage en base de données
 * @author ETY15
 *
 */
public interface AvantageRepository extends JpaRepository<Avantage, Integer> {

	/**
	 * Renvoie un Avantage de code code
	 * @param code le code de l'Avantage
	 * @return
	 */
	Avantage findOneByCode(String code);
}
