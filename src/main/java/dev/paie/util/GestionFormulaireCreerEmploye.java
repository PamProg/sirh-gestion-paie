package dev.paie.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class GestionFormulaireCreerEmploye {

	@Autowired private EntrepriseRepository entrepriseRepo;
	@Autowired private ProfilRemunerationRepository profilRepo;
	@Autowired private GradeRepository gradeRepo;
	
	public Entreprise getEntrepriseWithName(String nomEntreprise) {
		Entreprise entreprise = entrepriseRepo.findOneByDenomination(nomEntreprise);
		return entreprise;
	}
	
	public ProfilRemuneration getProfilWithCode(String codeProfil) {
		ProfilRemuneration profil = profilRepo.findOneByCode(codeProfil);
		return profil;
	}
	
	public Grade getGradeWithCode(String codeGrade) {
		Grade grade = gradeRepo.findOneByCode(codeGrade);
		return grade;
	}
	
}
