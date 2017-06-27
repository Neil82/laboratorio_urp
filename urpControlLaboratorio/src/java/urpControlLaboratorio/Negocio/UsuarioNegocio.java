
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Usuario;
import urpControlLaboratorio.Datos.JdbcUsuariosDao;
public class UsuarioNegocio {
    private JdbcUsuariosDao usuariosDao = new JdbcUsuariosDao(); // usuariosDao declarada en el property del bean del applicationContext id="usuariossManager"
    private UsuarioValidator validador = new UsuarioValidator();
    
    public List<Usuario> getUsuarios() {
        // return products;
        return usuariosDao.getUsuarios();
    } 
    
    public Usuario getUsuario(String id) {
        // return products;
        return usuariosDao.getUsuario(id);
    } 
    
    public void insertUsuario(Usuario usuario) {
        
        if(this.validador.validate(usuario))
            usuariosDao.insertUsuario(usuario);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateUsuario(Usuario usuario, String id) {
        usuariosDao.updateUsuario(usuario, id);                  
    }
    
    public void deleteUsuario(String id) {
        usuariosDao.deleteUsuario(id);                  
    }
   
}
