package dev.paie.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controleur gérant la connexion
 * @author ETY15
 *
 */
@Controller
@RequestMapping("/connexion")
public class ConnexionController {
	
	@GetMapping
	public String afficherPageCreer() {
		return "connexion";
	}
}