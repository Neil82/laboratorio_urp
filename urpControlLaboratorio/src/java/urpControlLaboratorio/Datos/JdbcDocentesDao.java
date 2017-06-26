package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Docente;



public class JdbcDocentesDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcDocentesDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Docente> getDocentes() {

        List<Docente> docentes = this.jdbctemplate.query("select id, nombres, apellidos from docente where estado=1", new JdbcDocentesDao.DocenteMapper());
        return docentes;
    } 
    
     public Docente getDocente(String id) {
        
        List<Docente> docentes =  this.jdbctemplate.query("select id, nombres, apellidos from docente where id='"+id+"'", new JdbcDocentesDao.DocenteMapper());
        return docentes.get(0);
        
    }
    
    public String getDocenteValidacion(String id) {
        
        String name;
        
        try {
            String sql = "select nombres from docente where id = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertDocente(Docente docente) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into docente (id, nombres, apellidos, password) values (?,?,?,?)",docente.getId(), docente.getNombres(), docente.getApellidos(), docente.getPassword());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateDocente(Docente docente, String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update docente "
                    + "set nombres = ?, "
                    + "set apellidos = ?, "
                    + "set password = ? "
                    + "where "
                    + "id = ?", 
                 docente.getNombres(), docente.getApellidos(), docente.getPassword(), id);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteDocente(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update docente "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class DocenteMapper implements ParameterizedRowMapper<Docente> { 
        public Docente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Docente docente  = new Docente();
            docente.setId(rs.getString("id"));
            docente.setNombres(rs.getString("nombres")); 
            docente.setApellidos(rs.getString("apellidos")); 
            return docente;
        } 
    } 
}
