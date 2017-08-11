package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Bean de configuration
 * Permet d'importer nos données depuis un fichier .xml
 * Ici : jdd-config.xml qui comprend quelques données
 * @author ETY15
 *
 */
// Marque un bean de configuration Spring
@Configuration
// Import de la configuration XML dans une configuration Java
@ImportResource("classpath:jdd-config.xml")
public class JeuxDeDonneesConfig {
	
}