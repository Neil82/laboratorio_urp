package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Aula;


public class JdbcAulasDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcAulasDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Aula> getAulas() {

        List<Aula> aulas = this.jdbctemplate.query("select id, aula from aula where estado=1", new JdbcAulasDao.AulaMapper());
        return aulas;
    } 
    
     public Aula getAula(String id) {
        
        List<Aula> aulas =  this.jdbctemplate.query("select id, aula from aula where id='"+id+"'", new JdbcAulasDao.AulaMapper());
        return aulas.get(0);
        
    }
     
     public List<Aula> getAulasForm(String id) {

        List<Aula> aulas = this.jdbctemplate.query("select id, aula from aula where id='"+id+"'", new JdbcAulasDao.AulaMapper());
        return aulas;
    } 
  
    public void insertAula(Aula aula) {
        
         this.jdbctemplate.update(
            "insert into aula (aula) values (?)", aula.getAula());
        
    }
    
    public void updateAula(Aula aula, String id) {
        
         this.jdbctemplate.update(
            "update aula "
                    + "set aula = ? "
                    + "where "
                    + "id = ?", 
                 aula.getAula(), id);
        
    }    
    
    public void deleteAula(String id) {
        
         this.jdbctemplate.update(
            "update aula "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);

    }
    
    
    
    
    public String getAulaValidacionInsert(String aula) {
        
        String name;
        
        try {
            String sql = "select aula from aula where aula = ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { aula }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    
    public String getAulaValidacionUpd(String aula, String id) {
        
        String name;
        
        try {
            String sql = "select aula from aula where aula = ? and id <> ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { aula, id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    
    
    private static class AulaMapper implements ParameterizedRowMapper<Aula> { 
        public Aula mapRow(ResultSet rs, int rowNum) throws SQLException {
            Aula aula  = new Aula();
            aula.setId(rs.getString("id"));
            aula.setAula(rs.getString("aula"));            
            return aula;
        } 
    } 

}
