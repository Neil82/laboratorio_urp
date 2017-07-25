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

        List<Anio> anios = this.jdbctemplate.query("select id, anio, descripcion from anio where estado=1", new JdbcAniosDao.AnioMapper());
        return anios;
    } 
    
    public Anio getAnio(String id) {
        
        List<Anio> anios =  this.jdbctemplate.query("select id, anio, descripcion from anio where id='"+id+"'", new JdbcAniosDao.AnioMapper());
        return anios.get(0);
        
    }
    
    public List<Anio> getAnioForm(String id) {
        
        List<Anio> anios =  this.jdbctemplate.query("select id, anio, descripcion from anio where id='"+id+"'", new JdbcAniosDao.AnioMapper());
        return anios;
        
    }
    
    
    public void insertAnio(Anio anio) {
        
         this.jdbctemplate.update(
            "insert into anio (anio, descripcion) values (?,?)",anio.getAnio(), anio.getDescripcion());

    }
    
    public void updateAnio(Anio anio, String id) {
        
         this.jdbctemplate.update(
            "update anio "
                    + "set anio = ?, descripcion = ? "
                    + "where "
                    + "id = ?", 
                 anio.getAnio(), anio.getDescripcion(), id);
        
    }    
    
    public void deleteAnio(String id) {
        
         this.jdbctemplate.update(
            "update anio "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
    }
    
    
    public String getAnioValidacionInsert(String anio) {
        
        String name;
        
        try {
            String sql = "select descripcion from anio where anio = ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { anio }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    public String getAnioValidacionUpd(String anio, String id) {
        
        String name;
        
        try {
            String sql = "select descripcion from anio where anio=? and id <> ? ";
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
            anio.setAnio(rs.getString("anio"));
            anio.setDescripcion(rs.getString("descripcion"));            
            return anio;
        } 
    } 
}
