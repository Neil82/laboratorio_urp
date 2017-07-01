
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Hora;
import urpControlLaboratorio.Datos.JdbcHorasDao;
public class HoraNegocio {
    
    private JdbcHorasDao horasDao = new JdbcHorasDao(); 
    
    public List<Hora> getHoras() {

        return horasDao.getHoras();
    } 
    
}
