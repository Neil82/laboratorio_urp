
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.CursoSemestre;
import urpControlLaboratorio.Datos.JdbcCursoSemestresDao;
public class CursoSemestreNegocio {
    private JdbcCursoSemestresDao cursoSemestresDao = new JdbcCursoSemestresDao(); // cursoSemestresDao declarada en el property del bean del applicationContext id="cursoSemestressManager"
    private CursoSemestreValidator validador = new CursoSemestreValidator();
    
    public List<CursoSemestre> getCursoSemestres() {
        // return products;
        return cursoSemestresDao.getCursoSemestres();
    } 
    
    public List<CursoSemestre> getCursoSemestreForm(String id_anio, String id_semestre) {
        // return products;
        return cursoSemestresDao.getCursoSemestreForm(id_anio,id_semestre);
    } 
    
    public CursoSemestre getCursoSemestre(String id) {
        // return products;
        return cursoSemestresDao.getCursoSemestre(id);
    } 
    
    public void insertCursoSemestre(CursoSemestre cursoSemestre) {
        
        if(this.validador.validate(cursoSemestre))
            cursoSemestresDao.insertCursoSemestre(cursoSemestre);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateCursoSemestre(CursoSemestre cursoSemestre, String id) {
        cursoSemestresDao.updateCursoSemestre(cursoSemestre, id);                  
    }
    
    public void deleteCursoSemestre(String id) {
        cursoSemestresDao.deleteCursoSemestre(id);                  
    }
   
}
