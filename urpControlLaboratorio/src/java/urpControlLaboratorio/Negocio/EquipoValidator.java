package urpControlLaboratorio.Negocio;

import urpControlLaboratorio.Datos.JdbcEquiposDao;
import urpControlLaboratorio.Entidades.Equipo;

public class EquipoValidator {
    
    private JdbcEquiposDao jdbc = new JdbcEquiposDao();

    
    public String validateInsert(Equipo equipo) {
    
        if (equipo.getEqnombre().trim() == "") {
            return "Ingrese el nombre del Equipo";
        }
        
        
        
        if (equipo.getCpu_marca().trim() == "") {
            return "Ingrese la marca del CPU";
        }
        
        if (equipo.getCpu_modelo().trim() == "") {
            return "Ingrese el Modelo del CPU";
        }
        
        if (equipo.getCpu_serie().trim() == "") {
            return "Ingrese el Número de Serie del CPU";
        }
        
        if (equipo.getProcesador().trim() == "") {
            return "Ingrese el tipo de Procesador del CPU";
        }
        
        if (equipo.getVelocidad().trim() == "") {
            return "Ingrese la velocidad del CPU";
        }
        
        
        
        
        
        if (equipo.getRam().trim() == "") {
            return "Ingrese la información de la RAM";
        }
        
        if (equipo.getDisco_d().trim() == "") {
            return "Ingrese el tamaño del Disco";
        }
        
        if (equipo.getTvideo().trim() == "") {
            return "Ingrese la información de la Tarjeta de Video";
        }
        
        
        
        
        if (equipo.getMonitor_marca().trim() == "") {
            return "Ingrese la marca del Monitor";
        }
        
        if (equipo.getMonitor_modelo().trim() == "") {
            return "Ingrese el Modelo del Monitor";
        }
        
        if (equipo.getMonitor_serie().trim() == "") {
            return "Ingrese el Número de Serie del Monitor";
        }
        
        
        
        
        if (equipo.getTeclado_marca().trim() == "") {
            return "Ingrese la marca del Teclado";
        }
        
        if (equipo.getTeclado_modelo().trim() == "") {
            return "Ingrese el Modelo del Teclado";
        }
        
        if (equipo.getTeclado_serie().trim() == "") {
            return "Ingrese el Número de Serie del Teclado";
        }
        
        
        
        
        if (equipo.getMouse_marca().trim() == "") {
            return "Ingrese la marca del Mouse";
        }
        
        if (equipo.getMouse_modelo().trim() == "") {
            return "Ingrese el Modelo del Mouse";
        }
        
        if (equipo.getMouse_serie().trim() == "") {
            return "Ingrese el Número de Serie del Mouse";
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
        
        
        
        if (equipo.getCpu_marca().trim() == "") {
            return "Ingrese la marca del CPU";
        }
        
        if (equipo.getCpu_modelo().trim() == "") {
            return "Ingrese el Modelo del CPU";
        }
        
        if (equipo.getCpu_serie().trim() == "") {
            return "Ingrese el Número de Serie del CPU";
        }
        
        if (equipo.getProcesador().trim() == "") {
            return "Ingrese el tipo de Procesador del CPU";
        }
        
        if (equipo.getVelocidad().trim() == "") {
            return "Ingrese la velocidad del CPU";
        }
        
        
        
        
        
        if (equipo.getRam().trim() == "") {
            return "Ingrese la información de la RAM";
        }
        
        if (equipo.getDisco_d().trim() == "") {
            return "Ingrese el tamaño del Disco";
        }
        
        if (equipo.getTvideo().trim() == "") {
            return "Ingrese la información de la Tarjeta de Video";
        }
        
        
        
        
        if (equipo.getMonitor_marca().trim() == "") {
            return "Ingrese la marca del Monitor";
        }
        
        if (equipo.getMonitor_modelo().trim() == "") {
            return "Ingrese el Modelo del Monitor";
        }
        
        if (equipo.getMonitor_serie().trim() == "") {
            return "Ingrese el Número de Serie del Monitor";
        }
        
        
        
        
        if (equipo.getTeclado_marca().trim() == "") {
            return "Ingrese la marca del Teclado";
        }
        
        if (equipo.getTeclado_modelo().trim() == "") {
            return "Ingrese el Modelo del Teclado";
        }
        
        if (equipo.getTeclado_serie().trim() == "") {
            return "Ingrese el Número de Serie del Teclado";
        }
        
        
        
        
        if (equipo.getMouse_marca().trim() == "") {
            return "Ingrese la marca del Mouse";
        }
        
        if (equipo.getMouse_modelo().trim() == "") {
            return "Ingrese el Modelo del Mouse";
        }
        
        if (equipo.getMouse_serie().trim() == "") {
            return "Ingrese el Número de Serie del Mouse";
        }
        
        if(jdbc.getEquipoValidacionUpd(equipo.getEqnombre(), id) != null){
            return "El nombre del Equipo ya se encuentra registrado.";
        }
    
        return "ok";
    }
    
}
