
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Curso;
import urpControlLaboratorio.Datos.JdbcCursosDao;


public class CursoNegocio {
    
    private JdbcCursosDao cursosDao = new JdbcCursosDao(); // cursosDao declarada en el property del bean del applicationContext id="cursossManager"
    private CursoValidator validador = new CursoValidator();
    
    public List<Curso> getCursos() {
        return cursosDao.getCursos();
    } 
    
    public Curso getCurso(String id) {
        return cursosDao.getCurso(id);
    } 
    
    public List<Curso> getCursoForm(String id) {
        return cursosDao.getCursoForm(id);
    } 
    
    public String insertCurso(Curso curso) {
        
        String resultado = this.validador.validateInsert(curso);
        
        if(resultado == "ok"){
            cursosDao.insertCurso(curso);
            resultado = "ok";
        } 
        
        return resultado;
    } 
    
    public String updateCurso(Curso curso, String id) {
        
        String resultado = this.validador.validateUpdate(curso, id);
        
        if(resultado == "ok"){
            cursosDao.updateCurso(curso, id); 
            resultado = "ok";
        } 
        
        return resultado;       
    }
    
    public void deleteCurso(String id) {
        cursosDao.deleteCurso(id);                  
    }
   
}
