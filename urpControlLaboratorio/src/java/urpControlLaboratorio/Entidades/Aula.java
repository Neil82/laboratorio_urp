package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Aula { 
    private String id = "";
    private String aula = "";
    private String equipo = "";
    private String marca = "";
    private String serieCpu = "";
    private String procesador = "";

    public String getSerieCpu() {
        return serieCpu;
    }

    public void setSerieCpu(String serieCpu) {
        this.serieCpu = serieCpu;
    }
    private String tipoAccion = "";
    private String botonAccion = "";
    private String msgError = "";
    
    public String getId() {
        return id;
    }    
    public void setId(String id) {
        this.id = id;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
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