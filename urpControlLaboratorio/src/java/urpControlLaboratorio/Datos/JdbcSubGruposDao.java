package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.SubGrupo;

public class JdbcSubGruposDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcSubGruposDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<SubGrupo> getSubGrupos() {

        List<SubGrupo> subgrupos = this.jdbctemplate.query("select id, descripcion from subgrupo where estado=1", new JdbcSubGruposDao.SubGrupoMapper());
        return subgrupos;
    } 
    
    private static class SubGrupoMapper implements ParameterizedRowMapper<SubGrupo> { 
        public SubGrupo mapRow(ResultSet rs, int rowNum) throws SQLException {
            SubGrupo subgrupo  = new SubGrupo();
            subgrupo.setId(rs.getString("id"));
            subgrupo.setDescripcion(rs.getString("descripcion"));            
            return subgrupo;
        } 
    } 
}
