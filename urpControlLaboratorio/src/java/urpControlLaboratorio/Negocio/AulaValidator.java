
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcAulasDao;
import urpControlLaboratorio.Entidades.Aula;

public class AulaValidator {
    
    private JdbcAulasDao jdbc = new JdbcAulasDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Aula.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Aula aula) {
    
        String id = aula.getId().trim(); 
        if ( id == "") {
            return false;
        }
        else {

            if(jdbc.getAulaValidacion(id) != null){
                return false;
            }

        }

        if (aula.getPc().trim() == "") {
            return false;
        }
        
        //validar que la PC no este insertada
        return true;
    }
    
}
