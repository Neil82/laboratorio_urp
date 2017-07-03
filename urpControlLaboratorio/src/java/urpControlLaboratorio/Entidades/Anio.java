package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Anio { 
    private String id = "";
    private String descripcion = "";
    private String tipoAccion = "";
    private String botonAccion = "";
    
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

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public String getBotonAccion() {
        return botonAccion;
    }

    public void setBotonAccion(String botonAccion) {
        this.botonAccion = botonAccion;
    }
        
    
}