
package urpControlLaboratorio.Negocio;

import java.util.List;
import urpControlLaboratorio.Entidades.Horario;
import urpControlLaboratorio.Datos.JdbcHorariosDao;
public class HorarioNegocio {
    private JdbcHorariosDao horariosDao = new JdbcHorariosDao(); // horariosDao declarada en el property del bean del applicationContext id="horariossManager"
    private HorarioValidator validador = new HorarioValidator();
    
    public List<Horario> getHorarios() {

        return horariosDao.getHorarios();
    } 
    
    public Horario getHorario(String id) {

        return horariosDao.getHorario(id);
    } 
    
    public List<Horario> getHorarioAjax(String id_anio, String id_semestre, String id_aula) {

        return horariosDao.getHorarioAjax(id_anio, id_semestre, id_aula);
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
