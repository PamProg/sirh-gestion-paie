package dev.paie.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Bean de configuration.
 * Permet d'initialiser Spring Security et de le configurer
 * @author ETY15
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private DataSource dataSource;
	
	/**
	 * Indiquer les droits des utilisateurs selon leur rôle.
	 * Récupère un utilisateur en base, vérifie s'il est actif, puis
	 * lui accorde des droit selon son rôle
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery("SELECT nom_utilisateur, mot_de_passe, est_actif FROM utilisateur WHERE nom_utilisateur=?")
		.authoritiesByUsernameQuery("SELECT nom_utilisateur, role FROM utilisateur WHERE nom_utilisateur=?");
	}

	/**
	 * Indique quelles pages sont accessibles par tous et lesquelles sont accessibles après connexion
	 * Indique la page de connexion pour les ressources non accessibles sans autorisations
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/mvc/connexion").permitAll();
	}
}