package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Hora { 
    private String id = "";
    private String descripcion = "";
    private String hora_fin = "";
    
    public String getId() {
        return id;
    }    
    public void setId(String id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }    

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }
        
    
}