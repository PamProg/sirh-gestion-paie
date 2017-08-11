package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.RemunerationEmploye;

/**
 * Permet la persistence des RemunerationEmploye en base de données
 * @author ETY15
 *
 */
public interface RemunerationEmployeRepository extends JpaRepository<RemunerationEmploye, Integer> {

}
