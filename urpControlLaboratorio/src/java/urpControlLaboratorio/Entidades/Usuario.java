package urpControlLaboratorio.Entidades; 
import java.io.Serializable;

public class Usuario { 
    private String dni = "";
    private String apellidos = "";
    private String nombres = "";
    private String usuario = "";
    private String password = "";
    private Boolean acreditado;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAcreditado() {
        return acreditado;
    }

    public void setAcreditado(Boolean acreditado) {
        this.acreditado = acreditado;
    }
    
    
     
}