
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Aula;
import urpControlLaboratorio.Datos.JdbcAulasDao;
public class AulaNegocio {
    private JdbcAulasDao aulasDao = new JdbcAulasDao(); // aulasDao declarada en el property del bean del applicationContext id="aulasManager"
    
    public List<Aula> getAulas() {
        // return products;
        return aulasDao.getAulas();
    } 
    
    public Aula getAula(String id) {
        // return products;
        return aulasDao.getAula(id);
    } 
    
    public void insertAula(Aula aula) {
        aulasDao.insertAula(aula);                  
    } 
    
    public void updateAula(Aula aula, String id) {
        aulasDao.updateAula(aula, id);                  
    }
    
    public void deleteAula(String id) {
        aulasDao.deleteAula(id);                  
    }
   
}
