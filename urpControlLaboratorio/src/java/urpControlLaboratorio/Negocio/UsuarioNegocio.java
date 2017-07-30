
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Usuario;
import urpControlLaboratorio.Datos.JdbcUsuariosDao;


public class UsuarioNegocio {
    
    private JdbcUsuariosDao usuariosDao = new JdbcUsuariosDao(); 
    private UsuarioValidator validador = new UsuarioValidator();
    
    public List<Usuario> getUsuarios() {

        return usuariosDao.getUsuarios();
    } 
    
    public Usuario getUsuario(String id) {

        return usuariosDao.getUsuario(id);
    } 
    
    public String insertUsuario(Usuario usuario) {
        
        String resultado = this.validador.validateInsert(usuario);
        
        if(resultado == "ok"){
            usuariosDao.insertUsuario(usuario);
            resultado = "ok";
        } 
        
        return resultado;        
    } 
    
    public String updateUsuario(Usuario usuario, String id) {
                        
        String resultado = this.validador.validateUpd(usuario, id);
        
        if(resultado == "ok"){
            usuariosDao.updateUsuario(usuario, id);  
            resultado = "ok";
        } 
        
        return resultado;  
    }
    
    public void deleteUsuario(String id) {
        usuariosDao.deleteUsuario(id);                  
    }
   
}
