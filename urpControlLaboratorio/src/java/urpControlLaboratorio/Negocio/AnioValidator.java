
package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcAniosDao;
import urpControlLaboratorio.Entidades.Anio;

public class AnioValidator {
    
    private JdbcAniosDao jdbc = new JdbcAniosDao();

    
    public String validateInsert(Anio anio) {
    
        String anio_ing = anio.getId().trim(); 
        
        if ( anio_ing == "") {
            return "Ingrese el Año";
        }
        else {

            if(jdbc.getAnioValidacionInsert(anio_ing) != null){
                return "La Año ingresado ya se encuentra registrado";
            }
             
            if (anio.getDescripcion().trim() == "") {
                return "Ingrese la descripción del Año";
            }
        }
       
        return "ok";
    }
    
    
    public String validateUpdate(Anio anio, String id) {
    
        String anio_ing = anio.getAnio().trim(); 
        
        if ( anio_ing == "") {
            return "Ingrese el Año";
        }
        else {

            if(jdbc.getAnioValidacionUpd(anio_ing, id) != null){
                return "La Año ingresado ya se encuentra registrado";
            }
             
            if (anio.getDescripcion().trim() == "") {
                return "Ingrese la descripción del Año";
            }
        }
       return "ok";
    }
    
}
