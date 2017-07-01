
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcCursoSemestresDao;
import urpControlLaboratorio.Entidades.CursoSemestre;

public class CursoSemestreValidator {
    
    private JdbcCursoSemestresDao jdbc = new JdbcCursoSemestresDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return CursoSemestre.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(CursoSemestre cursoSemestre) {
    
       
        if (cursoSemestre.getId_anio().trim() == "") {
            return false;
        }
        
        if (cursoSemestre.getId_curso().trim() == "") {
            return false;
        }
        
        if (cursoSemestre.getId_docente().trim() == "") {
            return false;
        }
        
        if (cursoSemestre.getId_grupo().trim() == "") {
            return false;
        }
        
        if (cursoSemestre.getId_semestre().trim() == "") {
            return false;
        }
        
        if (cursoSemestre.getId_subgrupo().trim() == "") {
            return false;
        }
        
        String id_anio = cursoSemestre.getId_anio().trim(); 
        String id_curso = cursoSemestre.getId_curso().trim(); 
        String id_grupo = cursoSemestre.getId_grupo().trim(); 
        String id_semestre = cursoSemestre.getId_semestre().trim(); 
        String id_subgrupo = cursoSemestre.getId_subgrupo().trim(); 
       
        if(jdbc.getCursoSemestreValidacion(id_anio,id_semestre,id_curso,id_grupo,id_subgrupo) != null){
            return false;
        }

        
        //validar que el CursoSemestre no este insertada
        return true;
    }
    
}
