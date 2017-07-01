package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Duracion;

public class JdbcDuracionDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcDuracionDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Duracion> getDuracion() {

        List<Duracion> duracions = this.jdbctemplate.query("select id, descripcion from duracion where estado=1", new JdbcDuracionDao.DuracionMapper());
        return duracions;
    } 
    
    private static class DuracionMapper implements ParameterizedRowMapper<Duracion> { 
        public Duracion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Duracion duracion  = new Duracion();
            duracion.setId(rs.getString("id"));
            duracion.setDescripcion(rs.getString("descripcion"));            
            return duracion;
        } 
    } 
}
