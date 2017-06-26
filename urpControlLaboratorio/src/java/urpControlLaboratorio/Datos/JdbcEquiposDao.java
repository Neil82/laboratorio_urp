package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Equipo;



public class JdbcEquiposDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcEquiposDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Equipo> getEquipos() {

        List<Equipo> equipos = this.jdbctemplate.query("select id, descripcion from equipo where estado=1", new JdbcEquiposDao.EquipoMapper());
        return equipos;
    } 
    
     public Equipo getEquipo(String id) {
        
        List<Equipo> equipos =  this.jdbctemplate.query("select id, descripcion from equipo where id='"+id+"'", new JdbcEquiposDao.EquipoMapper());
        return equipos.get(0);
        
    }
    
    public String getEquipoValidacion(String id) {
        
        String name;
        
        try {
            String sql = "select descripcion from equipo where id = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertEquipo(Equipo equipo) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into equipo (id, descripcion) values (?,?)",equipo.getId(), equipo.getDescripcion());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateEquipo(Equipo equipo, String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update equipo "
                    + "set descripcion = ? "
                    + "where "
                    + "id = ?", 
                 equipo.getDescripcion(), id);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteEquipo(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update equipo "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class EquipoMapper implements ParameterizedRowMapper<Equipo> { 
        public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Equipo equipo  = new Equipo();
            equipo.setId(rs.getString("id"));
            equipo.setDescripcion(rs.getString("descripcion"));            
            return equipo;
        } 
    } 
}
