
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcCursosDao;
import urpControlLaboratorio.Entidades.Curso;

public class CursoValidator {
    
    private JdbcCursosDao jdbc = new JdbcCursosDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Curso.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Curso curso) {
    
        String id = curso.getId().trim(); 
        if ( id == "") {
            return false;
        }
        else {

            if(jdbc.getCursoValidacion(id) != null){
                return false;
            }

        }

        if (curso.getDescripcion().trim() == "") {
            return false;
        }
        
        //validar que el CUrso no este insertada
        return true;
    }
    
}
