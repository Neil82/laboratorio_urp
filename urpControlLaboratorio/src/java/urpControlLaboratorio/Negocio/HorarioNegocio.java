
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Horario;
import urpControlLaboratorio.Datos.JdbcHorariosDao;
public class HorarioNegocio {
    private JdbcHorariosDao horariosDao = new JdbcHorariosDao(); // horariosDao declarada en el property del bean del applicationContext id="horariossManager"
    private HorarioValidator validador = new HorarioValidator();
    
    public List<Horario> getHorarios() {
        // return products;
        return horariosDao.getHorarios();
    } 
    
    public Horario getHorario(String id) {
        // return products;
        return horariosDao.getHorario(id);
    } 
    
    public void insertHorario(Horario horario) {
        
        if(this.validador.validate(horario))
            horariosDao.insertHorario(horario);
        //else
            //regresar mensaje de error                  
    } 
    
    public void updateHorario(Horario horario, String id) {
        horariosDao.updateHorario(horario, id);                  
    }
    
    public void deleteHorario(String id) {
        horariosDao.deleteHorario(id);                  
    }
   
}
