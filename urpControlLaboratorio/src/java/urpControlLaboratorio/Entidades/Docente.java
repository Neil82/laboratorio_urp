package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Docente { 
    private String id;
    private String coddocente;
    private String nombres;
    private String apellidos;
    private String password;
    private String docente_nom;
    private String tipoAccion = "";
    private String botonAccion = "";
    private String msgError = "";
    
    public String getId() {
        return id;
    }    
    public void setId(String id) {
        this.id = id;
    }

    public String getCoddocente() {
        return coddocente;
    }

    public void setCoddocente(String coddocente) {
        this.coddocente = coddocente;
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

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }
}