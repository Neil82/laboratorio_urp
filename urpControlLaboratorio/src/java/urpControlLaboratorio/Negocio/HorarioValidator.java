
package urpControlLaboratorio.Negocio;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import urpControlLaboratorio.Datos.JdbcHorariosDao;
import urpControlLaboratorio.Entidades.Horario;

public class HorarioValidator {
    
    private JdbcHorariosDao jdbc = new JdbcHorariosDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Horario.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Horario horario) {
    
        if (horario.getId_anio().trim() == "") {
            return false;
        }
        
        if (horario.getId_aula().trim() == "") {
            return false;
        }
        
        if (horario.getId_cursosemestre().trim() == "") {
            return false;
        }
        
        if (horario.getId_dia().trim() == "") {
            return false;
        }
        
        if (horario.getId_duracion().trim() == "") {
            return false;
        }
        
        if (horario.getId_hinicio().trim() == "") {
            return false;
        }
        
        if (horario.getId_semestre().trim() == "") {
            return false;
        }
        
        String id_anio = horario.getId_anio().trim(); 
        String id_aula = horario.getId_aula().trim(); 
        String id_semestre = horario.getId_semestre().trim();
        String id_dia = horario.getId_dia().trim(); 
        String id_hinicio = horario.getId_hinicio().trim();
        String id_hfin = horario.getId_duracion().trim(); 
        String id_cursosemestre = horario.getId_cursosemestre().trim(); 
          
        if(jdbc.getHorarioValidacion(id_anio,id_semestre,id_aula,id_dia,id_hinicio,id_hfin,id_cursosemestre) != null){
            return false;
        }
     
        //validar que el Horario no este insertada
        return true;
    }
    
}
