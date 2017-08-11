package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Utilisateur;

/**
 * Permet la persistence des Utilisateur en base de données
 * @author ETY15
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
