package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Grade;

/**
 * Permet la persistence des Grade en base de données
 * @author ETY15
 *
 */
public interface GradeRepository extends JpaRepository<Grade, Integer>{
	Grade findOneByCode(String codeGrade);
}
