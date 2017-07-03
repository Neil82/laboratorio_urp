package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Grupo;

public class JdbcGruposDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcGruposDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Grupo> getGrupos() {

        List<Grupo> grupos = this.jdbctemplate.query("select id, descripcion from grupo where estado=1", new JdbcGruposDao.GrupoMapper());
        return grupos;
    } 
    
    public List<Grupo> getGrupoForm(String id) {

        List<Grupo> grupos = this.jdbctemplate.query("select id, descripcion from grupo where id='"+id+"'", new JdbcGruposDao.GrupoMapper());
        return grupos;
    } 
    
    private static class GrupoMapper implements ParameterizedRowMapper<Grupo> { 
        public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Grupo grupo  = new Grupo();
            grupo.setId(rs.getString("id"));
            grupo.setDescripcion(rs.getString("descripcion"));            
            return grupo;
        } 
    } 
}
