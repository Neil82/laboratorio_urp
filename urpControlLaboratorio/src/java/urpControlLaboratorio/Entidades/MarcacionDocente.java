package urpControlLaboratorio.Entidades; 

public class MarcacionDocente { 
    private String id_marcacion = "";
    private String aula = "";
    private String curso = "";
    private String docente = "";
    private String semestre = "";
    private String inicio = "";
    private String fin = "";
    private String tipo = "";
    private String extemporanea = "";
    private String id_docente = "";
    private String cod_docente = "";
    
    private String tipoAccion = "";
    private String botonAccion = "";
    private String msgError = "";

    private String docenteSel = "";
    
    public String getId_marcacion() {
        return id_marcacion;
    }

    public void setId_marcacion(String id_marcacion) {
        this.id_marcacion = id_marcacion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getExtemporanea() {
        return extemporanea;
    }

    public void setExtemporanea(String extemporanea) {
        this.extemporanea = extemporanea;
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

    public String getDocenteSel() {
        return docenteSel;
    }

    public void setDocenteSel(String docenteSel) {
        this.docenteSel = docenteSel;
    }

    public String getId_docente() {
        return id_docente;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    public String getCod_docente() {
        return cod_docente;
    }

    public void setCod_docente(String cod_docente) {
        this.cod_docente = cod_docente;
    }

    
}