package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Curso {
    private String id;
    private String Codcurso;
    private String Descripcion;
    private String tipoAccion = "";
    private String botonAccion = "";
    private String msgError = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCodcurso() {
        return Codcurso;
    }

    public void setCodcurso(String Codcurso) {
        this.Codcurso = Codcurso;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
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