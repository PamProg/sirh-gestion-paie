package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Periode;

/**
 * Permet la persistence des Periode en base de données
 * @author ETY15
 *
 */
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

}
