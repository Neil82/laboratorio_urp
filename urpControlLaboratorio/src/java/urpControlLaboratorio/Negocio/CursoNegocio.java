
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Curso;
import urpControlLaboratorio.Datos.JdbcCursosDao;
public class CursoNegocio {
    private JdbcCursosDao cursosDao = new JdbcCursosDao(); // cursosDao declarada en el property del bean del applicationContext id="cursossManager"
    private CursoValidator validador = new CursoValidator();
    
    public List<Curso> getCursos() {
        // return products;
        return cursosDao.getCursos();
    } 
    
    public Curso getCurso(String id) {
        // return products;
        return cursosDao.getCurso(id);
    } 
    
    public void insertCurso(Curso curso) {
        
        if(this.validador.validate(curso))
            cursosDao.insertCurso(curso);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateCurso(Curso curso, String id) {
        cursosDao.updateCurso(curso, id);                  
    }
    
    public void deleteCurso(String id) {
        cursosDao.deleteCurso(id);                  
    }
   
}
