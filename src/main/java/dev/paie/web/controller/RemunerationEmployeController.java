package dev.paie.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.util.GestionFormulaireCreerEmploye;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired private RemunerationEmployeRepository employeRepo;
	
	@Autowired private EntrepriseRepository entrepriseRepo;
	@Autowired private ProfilRemunerationRepository profilRepo;
	@Autowired private GradeRepository gradeRepo;
	
	@Autowired private GestionFormulaireCreerEmploye gestionFormulaire;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmployes() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmployes");
		
		List<RemunerationEmploye> employes = employeRepo.findAll();
		mv.addObject("employes", employes);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmployeForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		
		List<Entreprise> entreprises = entrepriseRepo.findAll();
		mv.addObject("entreprises", entreprises);
		
		List<ProfilRemuneration> profils = profilRepo.findAll();
		mv.addObject("profils", profils);
		
		List<Grade> grades = gradeRepo.findAll();
		mv.addObject("grades", grades);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmployePost(HttpServletRequest req) {
		String matricule = req.getParameter("matricule");
		String nomEntreprise = req.getParameter("entreprise");
		String codeProfil = req.getParameter("profil");
		String codeGrade = req.getParameter("grade");
		
		Entreprise entreprise = gestionFormulaire.getEntrepriseWithName(nomEntreprise);
		ProfilRemuneration profil = gestionFormulaire.getProfilWithCode(codeProfil);
		Grade grade = gestionFormulaire.getGradeWithCode(codeGrade);
		
		employeRepo.save(new RemunerationEmploye(matricule, entreprise, profil, grade));
		
		return "redirect:/mvc/employes/creer";
//		return "redirect:creer";
	}
	
	
}