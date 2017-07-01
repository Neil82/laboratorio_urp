package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Hora;

public class JdbcHorasDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcHorasDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Hora> getHoras() {

        List<Hora> horas = this.jdbctemplate.query("select id, descripcion from hora where estado=1", new JdbcHorasDao.HoraMapper());
        return horas;
    } 
    
    private static class HoraMapper implements ParameterizedRowMapper<Hora> { 
        public Hora mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hora hora  = new Hora();
            hora.setId(rs.getString("id"));
            hora.setDescripcion(rs.getString("descripcion"));            
            return hora;
        } 
    } 
}
