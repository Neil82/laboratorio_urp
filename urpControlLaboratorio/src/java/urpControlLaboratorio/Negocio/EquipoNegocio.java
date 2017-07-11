
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Equipo;
import urpControlLaboratorio.Datos.JdbcEquiposDao;
public class EquipoNegocio {
    private JdbcEquiposDao equiposDao = new JdbcEquiposDao(); // equiposDao declarada en el property del bean del applicationContext id="equipossManager"
    private EquipoValidator validador = new EquipoValidator();
    
    public List<Equipo> getEquipos() {
        return equiposDao.getEquipos();
    } 
    
    public Equipo getEquipo(String id) {
        return equiposDao.getEquipo(id);
    } 
    
    public String insertEquipo(Equipo equipo) {
        
        String resultado = this.validador.validateInsert(equipo);
        
        if(resultado == "ok"){
            equiposDao.insertEquipo(equipo);
            resultado = "ok";
        } 
        
        return resultado;
                   
    } 
    
    public String updateEquipo(Equipo equipo, String id) {
        
        String resultado = this.validador.validateUpdate(equipo, id);
        
        if(resultado == "ok"){
            equiposDao.updateEquipo(equipo, id);    
            resultado = "ok";
        } 
        
        return resultado;  
                      
    }
    
    public void deleteEquipo(String id) {
        equiposDao.deleteEquipo(id);                  
    }
   
}
