package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

/**
 * Bean de Service.
 * Permet d'insérer, de mettre à jour et de récupérer des Grade en base de données
 * en utilisant une syntaxe SQL, grâce à JDBC
 * @author ETY15
 *
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	/**
	 * Initialise le template JDBC avec notre DataSource
	 * @param dataSource
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Sauve un Grade en bdd
	 */
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade(id, code, nb_heures_base, taux_base) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, nouveauGrade.getId(),
									  nouveauGrade.getCode(), 
									  nouveauGrade.getNbHeuresBase(), 
									  nouveauGrade.getTauxBase());
	}

	/**
	 * Met à jour un Grade en bdd
	 */
	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET code = ?, nb_heures_base = ?, taux_base = ? WHERE id = ?";
		this.jdbcTemplate.update(sql, grade.getCode(), 
									  grade.getNbHeuresBase(), 
									  grade.getTauxBase(),
									  grade.getId());
	}

	/**
	 * Récupère tous les Grade en bdd
	 */
	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM grade";
		return this.jdbcTemplate.query(sql, (rs, rowNum) -> {
			Grade g = new Grade();
			g.setId(rs.getInt("id"));
			g.setCode(rs.getString("code"));
			g.setNbHeuresBase(rs.getBigDecimal("nb_heures_base"));
			g.setTauxBase(rs.getBigDecimal("taux_base"));
			return g;
		});
	}
}
