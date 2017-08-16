package dev.paie.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dev.paie.config.SecurityConfig;
import dev.paie.config.ServicesConfig;
import dev.paie.spring.JpaConfig;

/**
 * Bean de Configuration.
 * Active Spring MVC
 * Import les Classe dont il va avoir besoin
 * Récupère les données/bean de divers fichiers xlm (qui seront utilisé dans l'initialisation)
 * Scan le package des Controller
 * Indique comment les vues seront "resolvées" (en indiquant un prefixe et un suffixe)
 * @author ETY15
 *
 */
@Configuration
@EnableWebMvc
@Import({JpaConfig.class, ServicesConfig.class, SecurityConfig.class})
@ImportResource({"classpath:cotisations-imposables.xml", 
				 "classpath:cotisations-non-imposables.xml",
				 "classpath:entreprises.xml",
				 "classpath:profils-remuneration.xml",
				 "classpath:grades.xml"})
@ComponentScan({"dev.paie.web.controller", "dev.paie.config.aspect"})
@EnableAspectJAutoProxy
public class WebAppConfig {
	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}