package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

/**
 * Permet de persister des Grade en base de données
 * @author ETY15
 *
 */
public interface GradeService {
	void sauvegarder(Grade nouveauGrade);

	void mettreAJour(Grade grade);

	List<Grade> lister();
}
