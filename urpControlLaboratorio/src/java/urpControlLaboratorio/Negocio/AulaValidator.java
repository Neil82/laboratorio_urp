
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcAulasDao;
import urpControlLaboratorio.Entidades.Aula;

public class AulaValidator {
    
    private final JdbcAulasDao jdbc = new JdbcAulasDao();

    
    public String validateInsert(Aula aula) {
    
        String aula_ing = aula.getAula().trim(); 
        
        if ( aula_ing == "") {
            return "Ingrese la descripción del Aula";
        }
        else {

            if(jdbc.getAulaValidacionInsert(aula_ing) != null){
                return "La Aula ingresada ya se encuentra registrada";
            }
              
        }
       return "ok";
    }
    
    
    public String validateUpdate(Aula aula, String id) {
    
        String aula_ing = aula.getAula().trim(); 
        
        if ( aula_ing == "") {
            return "Ingrese la descripción del Aula";
        }
        else {

            if(jdbc.getAulaValidacionUpd(aula_ing, id) != null){
                return "La Aula ingresada ya se encuentra registrada";
            }
              
        }
       return "ok";
    }

}
