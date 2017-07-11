
package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcHorariosDao;
import urpControlLaboratorio.Entidades.Horario;

public class HorarioValidator {
    
    private JdbcHorariosDao jdbc = new JdbcHorariosDao();

    
    public String validateInsert(Horario horario) {
    
        if (horario.getId_anio().trim() == "") {
            return "Seleccione el Año.";
        }
        
        if (horario.getId_aula().trim() == "") {
            return "Seleccione el Aula.";
        }
        
        if (horario.getId_cursosemestre().trim() == "") {
            return "Seleccione el Curso/Profesor.";
        }
        
        if (horario.getId_dia().trim() == "") {
            return "Seleccione el Día.";
        }
        
        if (horario.getId_duracion().trim() == "") {
            return "Seleccione la Duración.";
        }
        
        if (horario.getId_hinicio().trim() == "") {
            return "Seleccione la Hora Inicio.";
        }
        
        if (horario.getId_semestre().trim() == "") {
            return "Seleccione el Semestre.";
        }
        
        String id_anio = horario.getId_anio().trim(); 
        String id_aula = horario.getId_aula().trim(); 
        String id_semestre = horario.getId_semestre().trim();
        String id_dia = horario.getId_dia().trim(); 
        String id_hinicio = horario.getId_hinicio().trim();
        String id_hfin = horario.getId_duracion().trim(); 
        String id_cursosemestre = horario.getId_cursosemestre().trim(); 
          
        if(jdbc.getHorarioValidacionInsert(id_anio,id_semestre,id_aula,id_dia,id_hinicio,id_hfin,id_cursosemestre) != null){
            return "Hay un conflicto con otro Curso en el horario indicado.";
        }
    
        return "ok";
    }
    
    
    public String validateUpdate(Horario horario, String id) {
    
        if (horario.getId_anio().trim() == "") {
            return "Seleccione el Año.";
        }
        
        if (horario.getId_aula().trim() == "") {
            return "Seleccione el Aula.";
        }
        
        if (horario.getId_cursosemestre().trim() == "") {
            return "Seleccione el Curso/Profesor.";
        }
        
        if (horario.getId_dia().trim() == "") {
            return "Seleccione el Día.";
        }
        
        if (horario.getId_duracion().trim() == "") {
            return "Seleccione la Duración.";
        }
        
        if (horario.getId_hinicio().trim() == "") {
            return "Seleccione la Hora Inicio.";
        }
        
        if (horario.getId_semestre().trim() == "") {
            return "Seleccione el Semestre.";
        }
        
        String id_anio = horario.getId_anio().trim(); 
        String id_aula = horario.getId_aula().trim(); 
        String id_semestre = horario.getId_semestre().trim();
        String id_dia = horario.getId_dia().trim(); 
        String id_hinicio = horario.getId_hinicio().trim();
        String id_hfin = horario.getId_duracion().trim(); 
        String id_cursosemestre = horario.getId_cursosemestre().trim(); 
          
        if(jdbc.getHorarioValidacionUpd(id_anio,id_semestre,id_aula,id_dia,id_hinicio,id_hfin,id_cursosemestre,id) != null){
            return "Hay un conflicto con otro Curso en el horario indicado.";
        }
    
        return "ok";
    }
    
}
