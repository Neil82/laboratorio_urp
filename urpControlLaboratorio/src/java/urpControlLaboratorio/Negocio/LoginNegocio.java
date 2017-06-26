
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Usuario;
import urpControlLaboratorio.Datos.JdbcLoginDao;
public class LoginNegocio {
    private JdbcLoginDao loginDao = new JdbcLoginDao(); // aulasDao declarada en el property del bean del applicationContext id="aulasManager"
        
    public Usuario comprobarCredenciales(Usuario usuario) {
        // return products;
        
        return loginDao.comprobarCredenciales(usuario);
    }     
}
