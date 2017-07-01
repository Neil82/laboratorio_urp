package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Dia;

public class JdbcDiasDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcDiasDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Dia> getDias() {

        List<Dia> dias = this.jdbctemplate.query("select id, descripcion from dia where estado=1", new JdbcDiasDao.DiaMapper());
        return dias;
    } 
    
    private static class DiaMapper implements ParameterizedRowMapper<Dia> { 
        public Dia mapRow(ResultSet rs, int rowNum) throws SQLException {
            Dia dia  = new Dia();
            dia.setId(rs.getString("id"));
            dia.setDescripcion(rs.getString("descripcion"));            
            return dia;
        } 
    } 
}
