package dev.paie.service;

import java.util.List;

import dev.paie.entite.Cotisation;

/**
 * Permet de persister des Cotisations en base de données
 * @author ETY15
 *
 */
public interface CotisationService {

	void sauvegarder(Cotisation nouvelleCotisation);

	void mettreAJour(Cotisation cotisation);

	List<Cotisation> lister();
}
