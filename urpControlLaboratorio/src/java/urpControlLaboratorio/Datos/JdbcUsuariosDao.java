package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Usuario;



public class JdbcUsuariosDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcUsuariosDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Usuario> getUsuarios() {

        List<Usuario> usuarios = this.jdbctemplate.query("select idusuario, dni, usuario, nombres, apellidos from usuario where estado=1", new JdbcUsuariosDao.UsuarioMapper());
        return usuarios;
    } 
    
     public Usuario getUsuario(String idusuario) {
        
        List<Usuario> usuarios =  this.jdbctemplate.query("select idusuario, dni, usuario, nombres, apellidos from usuario where idusuario='"+idusuario+"'", new JdbcUsuariosDao.UsuarioMapper());
        return usuarios.get(0);
        
    }
    
    public String getUsuarioValidacion(String idusuario) {
        
        String name;
        
        try {
            String sql = "select nombres from usuario where idusuario = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { idusuario }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertUsuario(Usuario usuario) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into usuario (dni, usuario, nombres, apellidos, password) values (?,?,?,?,?)", usuario.getDni(), usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getPassword());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateUsuario(Usuario usuario, String idusuario) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update usuario "
                    + "set usuario = ?, "
                    + "set nombres = ?, "
                    + "set apellidos = ?, "
                    + "set password = ? "
                    + "where "
                    + "idusuario = ?", 
                 usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getPassword(), idusuario);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteUsuario(String idusuario) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update usuario "
                    + "set estado = 0 "
                    + "where "
                    + "idusuario = ?", 
                 idusuario);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class UsuarioMapper implements ParameterizedRowMapper<Usuario> { 
        public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Usuario usuario  = new Usuario();
            usuario.setIdusuario(rs.getString("idusuario"));
            usuario.setDni(rs.getString("dni")); 
            usuario.setUsuario(rs.getString("usuario")); 
            usuario.setNombres(rs.getString("nombres")); 
            usuario.setApellidos(rs.getString("apellidos")); 
            return usuario;
        } 
    } 
}
