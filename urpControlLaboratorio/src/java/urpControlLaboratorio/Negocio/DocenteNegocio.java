
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Docente;
import urpControlLaboratorio.Datos.JdbcDocentesDao;
public class DocenteNegocio {
    private JdbcDocentesDao docentesDao = new JdbcDocentesDao(); // docentesDao declarada en el property del bean del applicationContext id="docentessManager"
    private DocenteValidator validador = new DocenteValidator();
    
    public List<Docente> getDocentes() {
        // return products;
        return docentesDao.getDocentes();
    } 
    
    public Docente getDocente(String id) {
        // return products;
        return docentesDao.getDocente(id);
    } 
    
    public void insertDocente(Docente docente) {
        
        if(this.validador.validate(docente))
            docentesDao.insertDocente(docente);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateDocente(Docente docente, String id) {
        docentesDao.updateDocente(docente, id);                  
    }
    
    public void deleteDocente(String id) {
        docentesDao.deleteDocente(id);                  
    }
   
}
