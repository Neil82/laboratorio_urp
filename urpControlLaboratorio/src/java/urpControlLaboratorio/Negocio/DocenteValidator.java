
package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcDocentesDao;
import urpControlLaboratorio.Entidades.Docente;

public class DocenteValidator {
    
    private JdbcDocentesDao jdbc = new JdbcDocentesDao();

    
    public String validateInsert(Docente docente) {
    
        String coddocente = docente.getCoddocente().trim(); 
        if ( coddocente == "") {
            return "Ingrese el Código del Docente";
        }
        else {

            if(jdbc.getDocenteValidacion(coddocente) != null){
                return "La Docente ingresado ya se encuentra registrado";
            }
        }

        if (docente.getNombres().trim() == "") {
            return "Ingrese los Nombres del Docente";
        }
        
        if (docente.getApellidos().trim() == "") {
            return "Ingrese los Apellidos del Docente";
        }
      
        return "ok";
    }
    
    
    public String validateUpdate(Docente docente, String id) {
    
        String coddocente = docente.getCoddocente().trim(); 
        
        if ( coddocente == "") {
            return "Ingrese el Código del Docente";
        }
        else {

            if(jdbc.getDocenteValidacionUpd(coddocente, id) != null){
                return "El Código de Docente ingresado ya se encuentra registrado";
            }
              
        }
       return "ok";
    }
    
}
