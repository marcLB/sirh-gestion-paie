package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO Grade (ID,CODE,NB_HEURES_BASE,TAUX_BASE) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(),nouveauGrade.getNbHeuresBase(),nouveauGrade.getTauxBase());	
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE Grade SET NB_HEURES_BASE=?,TAUX_BASE=? WHERE CODE=?";
		this.jdbcTemplate.update(sql, grade.getNbHeuresBase(),grade.getTauxBase(),grade.getCode());			
	}
	
	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM Grade";
		return this.jdbcTemplate.query(sql, (rs,rowNum) -> {
			Grade gr = new Grade();
			gr.setId(rs.getInt("ID"));
			gr.setCode(rs.getString("CODE"));
			gr.setNbHeuresBase(rs.getBigDecimal("NB_HEURES_BASE"));
			gr.setTauxBase(rs.getBigDecimal("TAUX_BASE"));
			return gr;
		});
	}
}