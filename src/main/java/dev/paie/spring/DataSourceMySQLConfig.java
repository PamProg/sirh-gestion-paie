package dev.paie.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Permet d'initialiser notre DataSource avec les informations nécessaires
 * @author ETY15
 *
 */
@Configuration
@PropertySource("classpath:app.properties")
public class DataSourceMySQLConfig {
	
	/**
	 * Bean indiquant les informations de connexion à une base de données
	 * @param driver le driver utilisé
	 * @param url l'url de notre base
	 * @param username l'utilisateur de notre base
	 * @param password le mot de passe de notre base
	 * @return
	 */
	@Bean
	public DataSource dataSource(@Value("${driver}") String driver,
								 @Value("${url}") String url,
								 @Value("${userdbname}") String username,
								 @Value("${password}") String password) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
}
