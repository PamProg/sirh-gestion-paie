package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.ProfilRemuneration;

/**
 * Permet la persistence des ProfilRemuneration en base de données
 * @author ETY15
 *
 */
public interface ProfilRemunerationRepository extends JpaRepository<ProfilRemuneration, Integer> {
	ProfilRemuneration findOneByCode(String codeProfil);
}
