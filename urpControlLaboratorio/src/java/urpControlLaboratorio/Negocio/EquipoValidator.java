
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcEquiposDao;
import urpControlLaboratorio.Entidades.Equipo;

public class EquipoValidator {
    
    private JdbcEquiposDao jdbc = new JdbcEquiposDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Equipo.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Equipo equipo) {
    
        String id = equipo.getId().trim(); 
        if ( id == "") {
            return false;
        }
        else {

            if(jdbc.getEquipoValidacion(id) != null){
                return false;
            }

        }

        if (equipo.getDescripcion().trim() == "") {
            return false;
        }
        
        //validar que el Equipo no este insertada
        return true;
    }
    
}
