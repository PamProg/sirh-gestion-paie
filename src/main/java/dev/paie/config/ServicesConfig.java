package dev.paie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;


/**
 * Bean de configuration.
 * Scan les package qui contiennent les services de notre application
 * Import les Bean utiles à son utilisation (ici JpaConfid et DataSourceMySQLConfig)
 * Active l'utilisation des Repository
 * @author ETY15
 *
 */
@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.util"})
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {
	
	/**
	 * Créé un bean PasswordEncoder utilisant l'algorithme BCrypt
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
