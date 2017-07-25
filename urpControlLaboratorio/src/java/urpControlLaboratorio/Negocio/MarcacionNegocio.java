
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Datos.JdbcMarcacionDao;
import urpControlLaboratorio.Entidades.MarcacionDocente;

public class MarcacionNegocio {
    
    private JdbcMarcacionDao marcacionDao = new JdbcMarcacionDao(); 
    
    public List<MarcacionDocente> getMarcaciones(String id) {
        return marcacionDao.getMarcaciones(id);
    } 

    public void finalizarMarcacion(String id) {
        marcacionDao.finalizarMarcacion(id);                  
    }
   
}
