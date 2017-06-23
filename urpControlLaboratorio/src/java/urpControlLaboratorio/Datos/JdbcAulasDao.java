package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Aula;



public class JdbcAulasDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcAulasDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Aula> getAulas() {

        List<Aula> aulas = this.jdbctemplate.query("select id, pc from aulas where estado=1", new JdbcAulasDao.AulaMapper());
        return aulas;
    } 
    
     public Aula getAula(String id) {
        
        List<Aula> aulas =  this.jdbctemplate.query("select id, pc from aulas where id='"+id+"'", new JdbcAulasDao.AulaMapper());
        return aulas.get(0);
        
    }
    
    public String getAulaValidacion(String id) {
        
        String sql = "select pc from aulas where id = ?";
	String name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id }, String.class);

	return name;
    } 
     
    public void insertAula(Aula aula) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into aulas values (?,?)",aula.getId(), aula.getPc());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateAula(Aula aula, String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update aulas "
                    + "set pc = ? "
                    + "where "
                    + "id = ?", 
                 aula.getPc(), id);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteAula(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update aulas "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class AulaMapper implements ParameterizedRowMapper<Aula> { 
        public Aula mapRow(ResultSet rs, int rowNum) throws SQLException {
            Aula aula  = new Aula();
            aula.setId(rs.getString("id"));
            aula.setPc(rs.getString("pc"));            
            return aula;
        } 
    } 
}