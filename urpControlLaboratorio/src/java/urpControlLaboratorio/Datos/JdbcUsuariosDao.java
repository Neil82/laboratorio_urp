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
    
    
     
    public void insertUsuario(Usuario usuario) {
        
         this.jdbctemplate.update(
            "insert into usuario (dni, usuario, nombres, apellidos, password) values (?,?,?,?,?)", usuario.getDni(), usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getPassword());
        
    }
    
    public void updateUsuario(Usuario usuario, String idusuario) {
        
        if(usuario.getPassword()!=""){
            
            this.jdbctemplate.update(
            "update usuario "
                    + "set usuario = ?, "
                    + "nombres = ?, "
                    + "apellidos = ?, "
                    + "password = ? "
                    + "where "
                    + "idusuario = ?", 
                 usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos(), usuario.getPassword(), idusuario);
        
        } else{
        
            this.jdbctemplate.update(
            "update usuario "
                    + "set usuario = ?, "
                    + "nombres = ?, "
                    + "apellidos = ? "
                    + "where "
                    + "idusuario = ?", 
                 usuario.getUsuario(), usuario.getNombres(), usuario.getApellidos(), idusuario);
            
        }
        
    }    
    
    public void deleteUsuario(String idusuario) {
        
         this.jdbctemplate.update(
            "update usuario "
                    + "set estado = 0 "
                    + "where "
                    + "idusuario = ?", 
                 idusuario);

    }
    
    
    public String getUsuarioValidacionInsertDNI(String dniusuario) {
        
        String name;
        
        try {
            String sql = "select dni from usuario where dni = ? and estado=1";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { dniusuario }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
        }
         
	return name;
    } 
    
    public String getUsuarioValidacionInsertUsername(String usuario) {
        
        String name;
        
        try {
            String sql = "select dni from usuario where usuario = ? and estado=1";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { usuario }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
        }
         
	return name;
    } 
    
    public String getUsuarioValidacionUpd(String dniusuario, String id) {
        
        String name;
        
        try {
            String sql = "select dni from usuario where dni = ? and idusuario <> ? and estado=1";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { dniusuario, id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
        }
         
	return name;
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
