package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcEquiposDao;
import urpControlLaboratorio.Entidades.Equipo;

public class EquipoValidator {
    
    private JdbcEquiposDao jdbc = new JdbcEquiposDao();

    
    public String validateInsert(Equipo equipo) {
    
        if (equipo.getEqnombre().trim() == "") {
            return "Ingrese el nombre del Equipo";
        }
        
        if (equipo.getProcesador().trim() == "") {
            return "Ingrese la marca del CPU";
        }
        
        if (equipo.getVelocidad().trim() == "") {
            return "Ingrese la velocidad del CPU";
        }
        
        if (equipo.getRam().trim() == "") {
            return "Ingrese la información de la RAM";
        }
        
        if (equipo.getDisco_d().trim() == "") {
            return "Ingrese el tamaño del disco D";
        }
        
        if (equipo.getTvideo().trim() == "") {
            return "Ingrese la marca del Monitor";
        }
        
        
        if(jdbc.getEquipoValidacionInsert(
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
            return "El nombre del Equipo ya se encuentra registrado.";
        }
    
        return "ok";
    }
    
    
    public String validateUpdate(Equipo equipo, String id) {
    
        if (equipo.getEqnombre().trim() == "") {
            return "Ingrese el nombre del Equipo";
        }
        
        if (equipo.getProcesador().trim() == "") {
            return "Ingrese la marca del CPU";
        }
        
        if (equipo.getVelocidad().trim() == "") {
            return "Ingrese la velocidad del CPU";
        }
        
        if (equipo.getRam().trim() == "") {
            return "Ingrese la información de la RAM";
        }
        
        if (equipo.getDisco_d().trim() == "") {
            return "Ingrese el tamaño del disco D";
        }
        
        if (equipo.getTvideo().trim() == "") {
            return "Ingrese la marca del Monitor";
        }
        
        if(jdbc.getEquipoValidacionUpd(equipo.getEqnombre(), id) != null){
            return "El nombre del Equipo ya se encuentra registrado.";
        }
    
        return "ok";
    }
    
}
