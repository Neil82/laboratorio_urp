package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Horario;



public class JdbcHorariosDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcHorariosDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Horario> getHorarios() {

        List<Horario> horarios = this.jdbctemplate.query("select id, nombres, apellidos from horario where estado=1", new JdbcHorariosDao.HorarioMapper());
        return horarios;
    } 
    
     public Horario getHorario(String id) {
        
        List<Horario> horarios =  this.jdbctemplate.query("select id, nombres, apellidos from horario where id='"+id+"'", new JdbcHorariosDao.HorarioMapper());
        return horarios.get(0);
        
    }
    
    public String getHorarioValidacion(String id) {
        
        String name;
        
        try {
            String sql = "select nombres from horario where id = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertHorario(Horario horario) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into horario (id, nombres, apellidos, password) values (?,?,?,?)",horario.getId(), horario.getNombres(), horario.getApellidos(), horario.getPassword());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateHorario(Horario horario, String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update horario "
                    + "set nombres = ?, "
                    + "set apellidos = ?, "
                    + "set password = ? "
                    + "where "
                    + "id = ?", 
                 horario.getNombres(), horario.getApellidos(), horario.getPassword(), id);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteHorario(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update horario "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class HorarioMapper implements ParameterizedRowMapper<Horario> { 
        public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Horario horario  = new Horario();
            horario.setId(rs.getString("id"));
            horario.setNombres(rs.getString("nombres")); 
            horario.setApellidos(rs.getString("apellidos")); 
            return horario;
        } 
    } 
}
