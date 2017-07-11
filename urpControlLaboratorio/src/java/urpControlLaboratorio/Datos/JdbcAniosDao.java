package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Anio;

public class JdbcAniosDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcAniosDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Anio> getAnios() {

        List<Anio> anios = this.jdbctemplate.query("select id, descripcion from anio where estado=1", new JdbcAniosDao.AnioMapper());
        return anios;
    } 
    
    public Anio getAnio(String id) {
        
        List<Anio> anios =  this.jdbctemplate.query("select id, descripcion from anio where id='"+id+"'", new JdbcAniosDao.AnioMapper());
        return anios.get(0);
        
    }
    
    public List<Anio> getAnioForm(String id) {
        
        List<Anio> anios =  this.jdbctemplate.query("select id, descripcion from anio where id='"+id+"'", new JdbcAniosDao.AnioMapper());
        return anios;
        
    }
    
    
    public void insertAnio(Anio anio) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into anio (id, descripcion) values (?,?)",anio.getId(), anio.getDescripcion());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateAnio(Anio anio, String id) {
        
         this.jdbctemplate.update(
            "update anio "
                    + "set id = ?, descripcion = ? "
                    + "where "
                    + "id = ?", 
                 anio.getDescripcion(), id);
        
    }    
    
    public void deleteAnio(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update anio "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    
    public String getAnioValidacionInsert(String id) {
        
        String name;
        
        try {
            String sql = "select descripcion from anio where id = ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    public String getAnioValidacionUpd(String anio, String id) {
        
        String name;
        
        try {
            String sql = "select descripcion from anio where id = ? and id <> ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { anio, id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    
    private static class AnioMapper implements ParameterizedRowMapper<Anio> { 
        public Anio mapRow(ResultSet rs, int rowNum) throws SQLException {
            Anio anio  = new Anio();
            anio.setId(rs.getString("id"));
            anio.setDescripcion(rs.getString("descripcion"));            
            return anio;
        } 
    } 
}
