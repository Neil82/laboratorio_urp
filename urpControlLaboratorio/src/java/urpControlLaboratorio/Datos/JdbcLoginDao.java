package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Datos.Conexion;
import urpControlLaboratorio.Entidades.Aula;
import urpControlLaboratorio.Entidades.Usuario;



public class JdbcLoginDao  { //  
    /** Logger for this class and subclasses */
    //protected final Log logger = LogFactory.getLog(getClass());
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcLoginDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public Usuario comprobarCredenciales(Usuario usuario) {
        //logger.info("Getting products!");
        List<Usuario> usuarioQuery =  this.jdbctemplate.query("select * from usuario where usuario='"+ usuario.getUsuario() +"' and password='"+ usuario.getPassword() +"'",new JdbcLoginDao.UsuarioMapper());
        return usuarioQuery.get(0);
    } 
    
    
    private static class UsuarioMapper implements ParameterizedRowMapper<Usuario> { 
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario  = new Usuario();
            usuario.setDni(rs.getString("dni"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setNombres(rs.getString("nombres"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setPassword(rs.getString("password"));            
            return usuario;
        } 
    } 
}
