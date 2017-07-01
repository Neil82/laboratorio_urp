
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Dia;
import urpControlLaboratorio.Datos.JdbcDiasDao;
public class DiaNegocio {
    
    private JdbcDiasDao diasDao = new JdbcDiasDao(); 
    
    public List<Dia> getDias() {

        return diasDao.getDias();
    } 
    
}
