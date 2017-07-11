
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Aula;
import urpControlLaboratorio.Datos.JdbcAulasDao;
public class AulaNegocio {
    
    private JdbcAulasDao aulasDao = new JdbcAulasDao(); // aulasDao declarada en el property del bean del applicationContext id="aulasManager"
    private AulaValidator validador = new AulaValidator();
    
    public List<Aula> getAulas() {
        return aulasDao.getAulas();
    } 
    
    public Aula getAula(String id) {
        return aulasDao.getAula(id);
    } 
    
    public List<Aula> getAulasForm(String id) {
        return aulasDao.getAulasForm(id);
    } 
    
    public String insertAula(Aula aula) {
        
        String resultado = this.validador.validateInsert(aula);
        
        if(resultado == "ok"){
            aulasDao.insertAula(aula);
            resultado = "ok";
        } 
        
        return resultado;
    }
    
    public String updateAula(Aula aula, String id) {
        
        String resultado = this.validador.validateUpdate(aula, id);
        
        if(resultado == "ok"){
            aulasDao.updateAula(aula, id);
            resultado = "ok";
        } 
        
        return resultado;                  
    }
    
    public void deleteAula(String id) {
        aulasDao.deleteAula(id);                  
    }
   
}
