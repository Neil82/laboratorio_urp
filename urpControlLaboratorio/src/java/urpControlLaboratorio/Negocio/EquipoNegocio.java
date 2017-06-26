
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Equipo;
import urpControlLaboratorio.Datos.JdbcEquiposDao;
public class EquipoNegocio {
    private JdbcEquiposDao equiposDao = new JdbcEquiposDao(); // equiposDao declarada en el property del bean del applicationContext id="equipossManager"
    private EquipoValidator validador = new EquipoValidator();
    
    public List<Equipo> getEquipos() {
        // return products;
        return equiposDao.getEquipos();
    } 
    
    public Equipo getEquipo(String id) {
        // return products;
        return equiposDao.getEquipo(id);
    } 
    
    public void insertEquipo(Equipo equipo) {
        
        if(this.validador.validate(equipo))
            equiposDao.insertEquipo(equipo);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateEquipo(Equipo equipo, String id) {
        equiposDao.updateEquipo(equipo, id);                  
    }
    
    public void deleteEquipo(String id) {
        equiposDao.deleteEquipo(id);                  
    }
   
}
