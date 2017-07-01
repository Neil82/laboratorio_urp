
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.SubGrupo;
import urpControlLaboratorio.Datos.JdbcSubGruposDao;
public class SubGrupoNegocio {
    
    private JdbcSubGruposDao subgruposDao = new JdbcSubGruposDao(); 
    
    public List<SubGrupo> getSubGrupos() {

        return subgruposDao.getSubGrupos();
    } 
    
}
