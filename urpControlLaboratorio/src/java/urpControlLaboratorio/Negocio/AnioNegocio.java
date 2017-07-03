
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
        // return products;
        return aniosDao.getAnio(id);
    } 
    
    public List<Anio> getAnioForm(String id) {
        return aniosDao.getAnioForm(id);
    } 
    
    public void insertAnio(Anio anio) {
        
        if(this.validador.validate(anio))
            aniosDao.insertAnio(anio);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateAnio(Anio anio, String id) {
        aniosDao.updateAnio(anio, id);                  
    }
    
    public void deleteAnio(String id) {
        aniosDao.deleteAnio(id);                  
    }
   
}
