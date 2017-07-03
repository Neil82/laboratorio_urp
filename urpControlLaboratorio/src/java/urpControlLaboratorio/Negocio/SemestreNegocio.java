
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Semestre;
import urpControlLaboratorio.Datos.JdbcSemestresDao;
public class SemestreNegocio {
    
    private JdbcSemestresDao semestresDao = new JdbcSemestresDao(); 
    
    public List<Semestre> getSemestres() {

        return semestresDao.getSemestres();
    } 
    
    
    public List<Semestre> getSemestreForm(String id) {

        return semestresDao.getSemestreForm(id);
    } 
    
}
