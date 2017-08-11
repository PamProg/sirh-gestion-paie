package dev.paie.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

/**
 * Classe utile permettant de récupérer les entités liées à notre 
 * formulaire de création d'employé
 * @author ETY15
 *
 */
@Service
public class GestionFormulaireCreerEmploye {

	@Autowired private EntrepriseRepository entrepriseRepo;
	@Autowired private ProfilRemunerationRepository profilRepo;
	@Autowired private GradeRepository gradeRepo;
	
	/**
	 * Récupère l'Entreprise de nom nomEntreprise
	 * @param nomEntreprise la dénomination de l'Entreprise
	 * @return
	 */
	public Entreprise getEntrepriseWithName(String nomEntreprise) {
		Entreprise entreprise = entrepriseRepo.findOneByDenomination(nomEntreprise);
		return entreprise;
	}
	
	/**
	 * Récupère le ProfilRemuneration de code codeProfil
	 * @param codeProfil le code du ProfilRemuneration
	 * @return
	 */
	public ProfilRemuneration getProfilWithCode(String codeProfil) {
		ProfilRemuneration profil = profilRepo.findOneByCode(codeProfil);
		return profil;
	}
	
	/**
	 * Récupère le Grade de code codeGrade
	 * @param codeGrade le code du Grade
	 * @return
	 */
	public Grade getGradeWithCode(String codeGrade) {
		Grade grade = gradeRepo.findOneByCode(codeGrade);
		return grade;
	}
	
}
