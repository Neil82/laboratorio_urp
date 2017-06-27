
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcHorariosDao;
import urpControlLaboratorio.Entidades.Horario;

public class HorarioValidator {
    
    private JdbcHorariosDao jdbc = new JdbcHorariosDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Horario.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Horario horario) {
    
        String id = horario.getId().trim(); 
        if ( id == "") {
            return false;
        }
        else {

            if(jdbc.getHorarioValidacion(id) != null){
                return false;
            }

        }

        if (horario.getNombres().trim() == "") {
            return false;
        }
        
        if (horario.getApellidos().trim() == "") {
            return false;
        }
        
        if (horario.getPassword().trim() == "") {
            return false;
        }
        
        //validar que el Horario no este insertada
        return true;
    }
    
}
