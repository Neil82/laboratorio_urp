
package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcCursosDao;
import urpControlLaboratorio.Entidades.Curso;

public class CursoValidator {
    
    private JdbcCursosDao jdbc = new JdbcCursosDao();

    public String validateInsert(Curso curso) {
    
        String Codcurso_ing = curso.getCodcurso().trim();
        
        if ( Codcurso_ing == "") {
            return "Ingrese el Código del Curso";
        }
        else {

            if(jdbc.getCursoValidacion(Codcurso_ing) != null){
                return "El Código del Curso ingresado ya se encuentra registrado";
            }
            
            if (curso.getDescripcion().trim() == "") {
                return "Ingrese la Descripción del Curso";
            }
        }
              
       return "ok";
    }
    
    
    
    public String validateUpdate(Curso curso, String id) {
    
        String Codcurso_ing = curso.getCodcurso().trim();
        
        if ( Codcurso_ing == "") {
            return "Ingrese el Código del Curso";
        }
        else {

            if(jdbc.getCursoValidacionUpd(Codcurso_ing, id) != null){
                return "El Curso ingresado ya se encuentra registrado";
            }
            
            if (curso.getDescripcion().trim() == "") {
                return "Ingrese la Descripción del Curso";
            }
              
        }
       return "ok";
    }
    
}
