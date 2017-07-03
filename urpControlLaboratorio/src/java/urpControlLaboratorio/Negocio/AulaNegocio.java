
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Aula;
import urpControlLaboratorio.Datos.JdbcAulasDao;
public class AulaNegocio {
    private JdbcAulasDao aulasDao = new JdbcAulasDao(); // aulasDao declarada en el property del bean del applicationContext id="aulasManager"
    private AulaValidator validador = new AulaValidator();
    
    public List<Aula> getAulas() {
        // return products;
        return aulasDao.getAulas();
    } 
    
    public Aula getAula(String id) {
        // return products;
        return aulasDao.getAula(id);
    } 
    
    public List<Aula> getAulasForm(String id) {
        return aulasDao.getAulasForm(id);
    } 
    
    public void insertAula(Aula aula) {
        
        if(this.validador.validate(aula))
            aulasDao.insertAula(aula);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateAula(Aula aula, String id) {
        aulasDao.updateAula(aula, id);                  
    }
    
    public void deleteAula(String id) {
        aulasDao.deleteAula(id);                  
    }
   
}
