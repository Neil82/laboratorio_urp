
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Anio;
import urpControlLaboratorio.Datos.JdbcAniosDao;
public class AnioNegocio {
    private JdbcAniosDao aniosDao = new JdbcAniosDao(); // aniosDao declarada en el property del bean del applicationContext id="aniosManager"
    private AnioValidator validador = new AnioValidator();
    
    public List<Anio> getAnios() {
        return aniosDao.getAnios();
    } 
    
    public Anio getAnio(String id) {
        return aniosDao.getAnio(id);
    } 
    
    public List<Anio> getAnioForm(String id) {
        return aniosDao.getAnioForm(id);
    }
    
    public String insertAnio(Anio anio) {
        
        String resultado = this.validador.validateInsert(anio);
        
        if(resultado == "ok"){
            aniosDao.insertAnio(anio);
            resultado = "ok";
        } 
        
        return resultado;       
    } 
    
    public String updateAnio(Anio anio, String id) {
        
        String resultado = this.validador.validateUpdate(anio, id);
        
        if(resultado == "ok"){
            aniosDao.updateAnio(anio, id);
            resultado = "ok";
        } 
        
        return resultado;                   
    }
    
    public void deleteAnio(String id) {
        aniosDao.deleteAnio(id);                  
    }
   
}
