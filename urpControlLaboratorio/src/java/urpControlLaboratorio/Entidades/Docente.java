package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Docente { 
    private String id;
    private String nombres;
    private String apellidos;
    private String password;
    private String docente_nom;
    
    public String getId() {
        return id;
    }    
    public void setId(String id) {
        this.id = id;
    }
    public String getNombres() {
        return nombres;
    }    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDocente_nom() {
        return docente_nom;
    }

    public void setDocente_nom(String docente_nom) {
        this.docente_nom = docente_nom;
    }

    
}