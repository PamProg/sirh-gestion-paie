package dev.paie.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Periode;

/**
 * Permet la persistence des Periode en base de données
 * @author ETY15
 *
 */
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {
	Periode findOneByDateDebutAndDateFin(LocalDate dateDebut, LocalDate dateFin);
}
