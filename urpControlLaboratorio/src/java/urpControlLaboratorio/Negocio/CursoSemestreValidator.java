
package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcCursoSemestresDao;
import urpControlLaboratorio.Entidades.CursoSemestre;

public class CursoSemestreValidator {
    
    private JdbcCursoSemestresDao jdbc = new JdbcCursoSemestresDao();

    
    public String validateInsert(CursoSemestre cursoSemestre) {
    
        if (cursoSemestre.getId_anio().trim() == "") {
            return "Seleccione el Año.";
        }
        
        if (cursoSemestre.getId_curso().trim() == "") {
            return "Seleccione el Curso.";
        }
        
        if (cursoSemestre.getId_docente().trim() == "") {
            return "Seleccione el Docente.";
        }
        
        if (cursoSemestre.getId_grupo().trim() == "") {
            return "Seleccione el Grupo.";
        }
        
        if (cursoSemestre.getId_semestre().trim() == "") {
            return "Seleccione el Semestre.";
        }
        
        if (cursoSemestre.getId_subgrupo().trim() == "") {
            return "Seleccione el Subgrupo.";
        }
        
        String id_anio = cursoSemestre.getId_anio().trim(); 
        String id_curso = cursoSemestre.getId_curso().trim(); 
        String id_grupo = cursoSemestre.getId_grupo().trim(); 
        String id_semestre = cursoSemestre.getId_semestre().trim(); 
        String id_subgrupo = cursoSemestre.getId_subgrupo().trim(); 
       
        if(jdbc.getCursoSemestreValidacionInsert(id_anio,id_semestre,id_curso,id_grupo,id_subgrupo) != null){
            return "Ya se ha registrado la combinación de este Curso/Semestre.";
        }

        return "ok";
    }
    
    
    public String validateUpdate(CursoSemestre cursoSemestre, String id) {
    
       
        if (cursoSemestre.getId_anio().trim() == "") {
            return "Seleccione el Año.";
        }
        
        if (cursoSemestre.getId_curso().trim() == "") {
            return "Seleccione el Curso.";
        }
        
        if (cursoSemestre.getId_docente().trim() == "") {
            return "Seleccione el Docente.";
        }
        
        if (cursoSemestre.getId_grupo().trim() == "") {
            return "Seleccione el Grupo.";
        }
        
        if (cursoSemestre.getId_semestre().trim() == "") {
            return "Seleccione el Semestre.";
        }
        
        if (cursoSemestre.getId_subgrupo().trim() == "") {
            return "Seleccione el Subgrupo.";
        }
        
        String id_anio = cursoSemestre.getId_anio().trim(); 
        String id_curso = cursoSemestre.getId_curso().trim(); 
        String id_grupo = cursoSemestre.getId_grupo().trim(); 
        String id_semestre = cursoSemestre.getId_semestre().trim(); 
        String id_subgrupo = cursoSemestre.getId_subgrupo().trim(); 
       
        if(jdbc.getCursoSemestreValidacionUpd(id_anio,id_semestre,id_curso,id_grupo,id_subgrupo, id) != null){
            return "Ya se ha registrado la combinación de este Curso/Semestre.";
        }

        return "ok";
    }
    
}