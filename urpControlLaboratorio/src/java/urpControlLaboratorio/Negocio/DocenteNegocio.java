
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Docente;
import urpControlLaboratorio.Datos.JdbcDocentesDao;
public class DocenteNegocio {
    private JdbcDocentesDao docentesDao = new JdbcDocentesDao(); // docentesDao declarada en el property del bean del applicationContext id="docentessManager"
    private DocenteValidator validador = new DocenteValidator();
    
    public List<Docente> getDocentes() {
        return docentesDao.getDocentes();
    } 
    
    public Docente getDocente(String id) {
        return docentesDao.getDocente(id);
    } 
    
    public List<Docente> getDocenteForm(String id) {
        return docentesDao.getDocenteForm(id);
    } 
    
    public String insertDocente(Docente docente) {
        
        String resultado = this.validador.validateInsert(docente);
        
        if(resultado == "ok"){
            docentesDao.insertDocente(docente);
            resultado = "ok";
        } 
        
        return resultado;
                 
    } 
    
    public String updateDocente(Docente docente, String id) {
        
        String resultado = this.validador.validateUpdate(docente, id);
        
        if(resultado == "ok"){
            docentesDao.updateDocente(docente, id); 
            resultado = "ok";
        } 
        
        return resultado;  
                     
    }
    
    public void deleteDocente(String id) {
        docentesDao.deleteDocente(id);                  
    }
   
}
