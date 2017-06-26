
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcDocentesDao;
import urpControlLaboratorio.Entidades.Docente;

public class DocenteValidator {
    
    private JdbcDocentesDao jdbc = new JdbcDocentesDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Docente.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Docente docente) {
    
        String id = docente.getId().trim(); 
        if ( id == "") {
            return false;
        }
        else {

            if(jdbc.getDocenteValidacion(id) != null){
                return false;
            }

        }

        if (docente.getNombres().trim() == "") {
            return false;
        }
        
        if (docente.getApellidos().trim() == "") {
            return false;
        }
        
        if (docente.getPassword().trim() == "") {
            return false;
        }
        
        //validar que el Docente no este insertada
        return true;
    }
    
}
