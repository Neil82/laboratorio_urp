package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Semestre;

public class JdbcSemestresDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcSemestresDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Semestre> getSemestres() {

        List<Semestre> semestres = this.jdbctemplate.query("select id, descripcion from semestre where estado=1", new JdbcSemestresDao.SemestreMapper());
        return semestres;
    } 
    
    public List<Semestre> getSemestreForm(String id) {
        
        List<Semestre> semestres =  this.jdbctemplate.query("select id, descripcion from semestre where id='"+id+"'", new JdbcSemestresDao.SemestreMapper());
        return semestres;
        
    }
    
    private static class SemestreMapper implements ParameterizedRowMapper<Semestre> { 
        public Semestre mapRow(ResultSet rs, int rowNum) throws SQLException {
            Semestre semestre  = new Semestre();
            semestre.setId(rs.getString("id"));
            semestre.setDescripcion(rs.getString("descripcion"));            
            return semestre;
        } 
    } 
}
