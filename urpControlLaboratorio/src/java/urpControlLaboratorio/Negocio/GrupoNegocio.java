
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Grupo;
import urpControlLaboratorio.Datos.JdbcGruposDao;
public class GrupoNegocio {
    
    private JdbcGruposDao gruposDao = new JdbcGruposDao(); 
    
    public List<Grupo> getGrupos() {

        return gruposDao.getGrupos();
    } 
    
}
