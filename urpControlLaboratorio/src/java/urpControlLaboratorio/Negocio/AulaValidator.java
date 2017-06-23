
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcAulasDao;
import urpControlLaboratorio.Entidades.Aula;

public class AulaValidator implements Validator {
    
    private JdbcAulasDao jdbc = new JdbcAulasDao();

    
    @Override
    public boolean supports(Class<?> type) {
        return Aula.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    
        Aula ia = (Aula) o;
        
        String id = ia.getId().trim(); 
        if ( id == "") {
            errors.rejectValue("id", "error.no-definido",
                null, "Valor requerido");
        }
        else {

            if(jdbc.getAulaValidacion(id) != null){
                errors.rejectValue("id", "error.elemento-existente",
                null, "Valor duplicado");
            }

        }

        if (ia.getPc().trim() == "") {
            errors.rejectValue("pc", "error.no-definido",
                null, "Valor requerido.");
        }
        
    }
    
}
