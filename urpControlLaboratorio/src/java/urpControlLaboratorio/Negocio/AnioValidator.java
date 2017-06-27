
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcAniosDao;
import urpControlLaboratorio.Entidades.Anio;

public class AnioValidator {
    
    private JdbcAniosDao jdbc = new JdbcAniosDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Anio.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Anio anio) {
    
        String id = anio.getId().trim(); 
        if ( id == "") {
            return false;
        }
        else {

            if(jdbc.getAnioValidacion(id) != null){
                return false;
            }

        }

        if (anio.getDescripcion().trim() == "") {
            return false;
        }
        
        //validar que la PC no este insertada
        return true;
    }
    
}
