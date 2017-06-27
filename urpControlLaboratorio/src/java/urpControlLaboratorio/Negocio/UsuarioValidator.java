
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcUsuariosDao;
import urpControlLaboratorio.Entidades.Usuario;

public class UsuarioValidator {
    
    private JdbcUsuariosDao jdbc = new JdbcUsuariosDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Usuario.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Usuario usuario) {
    
        String user = usuario.getUsuario().trim(); 
        if ( user == "") {
            return false;
        }
        else {

            if(jdbc.getUsuarioValidacion(user) != null){
                return false;
            }

        }

        if (usuario.getNombres().trim() == "") {
            return false;
        }
        
        if (usuario.getApellidos().trim() == "") {
            return false;
        }
        
        if (usuario.getPassword().trim() == "") {
            return false;
        }
        
        //validar que el Usuario no este insertada
        return true;
    }
    
}
