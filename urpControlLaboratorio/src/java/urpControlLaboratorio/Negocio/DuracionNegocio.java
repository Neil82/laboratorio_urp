
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Duracion;
import urpControlLaboratorio.Datos.JdbcDuracionDao;
public class DuracionNegocio {
    
    private JdbcDuracionDao duracionDao = new JdbcDuracionDao(); 
    
    public List<Duracion> getDuracion() {

        return duracionDao.getDuracion();
    } 
    
}
