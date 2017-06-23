package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Equipo { 
    private String id;
    private String Descripcion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    

}