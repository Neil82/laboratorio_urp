
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.CursoSemestre;
import urpControlLaboratorio.Datos.JdbcCursoSemestresDao;


public class CursoSemestreNegocio {
    private JdbcCursoSemestresDao cursoSemestresDao = new JdbcCursoSemestresDao(); // cursoSemestresDao declarada en el property del bean del applicationContext id="cursoSemestressManager"
    private CursoSemestreValidator validador = new CursoSemestreValidator();
    
    public List<CursoSemestre> getCursoSemestres() {
        return cursoSemestresDao.getCursoSemestres();
    } 
    
    public List<CursoSemestre> getCursoSemestreForm(String id_anio, String id_semestre) {
        return cursoSemestresDao.getCursoSemestreForm(id_anio,id_semestre);
    } 
    
    public List<CursoSemestre> getCursoSemestreAjax(String id_anio, String id_semestre) {
        return cursoSemestresDao.getCursoSemestreAjax(id_anio,id_semestre);
    } 
    
    public CursoSemestre getCursoSemestre(String id) {
        return cursoSemestresDao.getCursoSemestre(id);
    } 
    
    public String insertCursoSemestre(CursoSemestre cursoSemestre) {

        String resultado = this.validador.validateInsert(cursoSemestre);
        
        if(resultado == "ok"){
            cursoSemestresDao.insertCursoSemestre(cursoSemestre);
            resultado = "ok";
        } 
        
        return resultado; 
    }
    
    public String updateCursoSemestre(CursoSemestre cursoSemestre, String id) {
        
    String resultado = this.validador.validateUpdate(cursoSemestre, id);
        
        if(resultado == "ok"){
            cursoSemestresDao.updateCursoSemestre(cursoSemestre, id);   
            resultado = "ok";
        } 
        
        return resultado; 
    
    }
    
    public void deleteCursoSemestre(String id) {
        cursoSemestresDao.deleteCursoSemestre(id);                  
    }
   
}