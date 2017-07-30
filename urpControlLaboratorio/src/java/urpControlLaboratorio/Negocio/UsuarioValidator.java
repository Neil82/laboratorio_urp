
package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcUsuariosDao;
import urpControlLaboratorio.Entidades.Usuario;

public class UsuarioValidator {
    
    private JdbcUsuariosDao jdbc = new JdbcUsuariosDao();

    
    public String validateInsert(Usuario usuario) {
    
        String user = usuario.getUsuario().trim();
        String dni = usuario.getDni().trim();
        
        if ( user == "") {
            return "Ingrese el Usuario";
        }
        else {

            if(jdbc.getUsuarioValidacionInsertUsername(user) != null){
                return "El Usuario ingresado ya se encuentra registrado.";
            }
        }
        
        if ( dni == "") {
            return "Ingrese el DNI del Usuario";
        }
        else {

            if(jdbc.getUsuarioValidacionInsertDNI(dni) != null){
                return "El DNI del Usuario ingresado ya se encuentra registrado.";
            }
        }

        if (usuario.getNombres().trim() == "") {
            return "Ingrese el nombre del usuario.";
        }
        
        if (usuario.getApellidos().trim() == "") {
            return "Ingrese los apellidos del usuario.";
        }
        
        if (usuario.getPassword().trim() == "") {
            return "Ingrese el Password del Usuario.";
        }
       
        return "ok";
    }
    
    
    public String validateUpd(Usuario usuario, String id) {
    
        String dni = usuario.getDni().trim(); 
        
        if (dni == "") {
            return "Ingrese el DNI del Usuario";
        }
        else {

            if(jdbc.getUsuarioValidacionUpd(dni, id) != null){
                return "El DNI del usuario ingresado ya se encuentra registrado.";
            }
        }

        if (usuario.getUsuario().trim() == "") {
            return "Ingrese el Usuario.";
        }
        
        if (usuario.getNombres().trim() == "") {
            return "Ingrese el nombre del usuario.";
        }
        
        if (usuario.getApellidos().trim() == "") {
            return "Ingrese los apellidos del usuario.";
        }
       
        return "ok";
    }
    
}
