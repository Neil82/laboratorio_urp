
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
    
    public String insertHorario(Horario horario) {
        
        String resultado = this.validador.validateInsert(horario);
        
        if(resultado == "ok"){
            horariosDao.insertHorario(horario);
            resultado = "ok";
        } 
        
        return resultado; 
        
    } 
    
    public String updateHorario(Horario horario, String id) {
        
        String resultado = this.validador.validateUpdate(horario, id);
        
        if(resultado == "ok"){
            horariosDao.updateHorario(horario, id); 
            resultado = "ok";
        } 
        
        return resultado;  
                         
    }
    
    public void deleteHorario(String id) {
        horariosDao.deleteHorario(id);                  
    }
   
}
