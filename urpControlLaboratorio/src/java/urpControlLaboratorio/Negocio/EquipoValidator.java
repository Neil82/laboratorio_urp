package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcEquiposDao;
import urpControlLaboratorio.Entidades.Equipo;

public class EquipoValidator {
    
    private JdbcEquiposDao jdbc = new JdbcEquiposDao();

    
    /*@Override
    public boolean supports(Class<?> type) {
        return Equipo.class.isAssignableFrom(type);
    }*/

    
    public boolean validate(Equipo equipo) {
    
        if (equipo.getEqnombre().trim() == "") {
            return false;
        }
        
        if (equipo.getProcesador().trim() == "") {
            return false;
        }
        
        if (equipo.getVelocidad().trim() == "") {
            return false;
        }
        
        if (equipo.getRam().trim() == "") {
            return false;
        }
        
        if (equipo.getDisco_d().trim() == "") {
            return false;
        }
        
        if (equipo.getTvideo().trim() == "") {
            return false;
        }
        
        if (equipo.getIdaula().trim() == "") {
            return false;
        }
        
        
        if(jdbc.getEquipoValidacion(
                equipo.getEqnombre(), 
                equipo.getCpu_marca(), 
                equipo.getCpu_modelo(), 
                equipo.getCpu_serie(), 
                equipo.getProcesador(), 
                equipo.getVelocidad(), 
                equipo.getRam(), 
                equipo.getDisco_d(), 
                equipo.getTvideo(), 
                equipo.getIdaula()
                ) != null){
            return false;
        }
    
        
        //validar que el Equipo no este insertada
        return true;
    }
    
}
