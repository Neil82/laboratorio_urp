package urpControlLaboratorio.Entidades; 
import java.util.List;

public class Horario { 
    private String id;
    private String id_anio;
    private String id_semestre;
    private String id_aula;
    private String id_dia;
    private String id_hinicio;
    private String hora_fin;
    private String id_duracion;
    private String id_cursosemestre;
    
    private String selAnio;
    private String selSemestre;
    private String selAula;
    private String selDia;
    private String selHoraInicio;
    private String selDuracion;
    private String selcursoSemestre;
    
    private List listAnio;
    private List listSemestre;
    private List listAula;
    private List listDia;
    private List listHora;
    private List listDuracion;
    private List listCursoSemestre;
    
    private String tipoAccion = "";
    private String botonAccion = "";
    private String accion = "";
    
    private String rep_horaInicio;
    private String rep_horaFin;
    private String rep_lunes;
    private String rep_martes;
    private String rep_miercoles;
    private String rep_jueves;
    private String rep_viernes;
    private String rep_sabado;
    
    private String rep_lunes_dur;
    private String rep_martes_dur;
    private String rep_miercoles_dur;
    private String rep_jueves_dur;
    private String rep_viernes_dur;
    private String rep_sabado_dur;
    
    private String rep_lunes_docente;
    private String rep_martes_docente;
    private String rep_miercoles_docente;
    private String rep_jueves_docente;
    private String rep_viernes_docente;
    private String rep_sabado_docente;
    
    private String msgError;
    
    public String getId() {
        return id;
    }    
    public void setId(String id) {
        this.id = id;
    }

    public String getId_anio() {
        return id_anio;
    }

    public void setId_anio(String id_anio) {
        this.id_anio = id_anio;
    }

    public String getId_semestre() {
        return id_semestre;
    }

    public void setId_semestre(String id_semestre) {
        this.id_semestre = id_semestre;
    }

    public String getId_aula() {
        return id_aula;
    }

    public void setId_aula(String id_aula) {
        this.id_aula = id_aula;
    }

    public String getId_dia() {
        return id_dia;
    }

    public void setId_dia(String id_dia) {
        this.id_dia = id_dia;
    }

    public String getId_hinicio() {
        return id_hinicio;
    }

    public void setId_hinicio(String id_hinicio) {
        this.id_hinicio = id_hinicio;
    }

    public String getId_duracion() {
        return id_duracion;
    }

    public void setId_duracion(String id_duracion) {
        this.id_duracion = id_duracion;
    }

    

    public String getId_cursosemestre() {
        return id_cursosemestre;
    }

    public void setId_cursosemestre(String id_cursosemestre) {
        this.id_cursosemestre = id_cursosemestre;
    }

    public List getListAnio() {
        return listAnio;
    }

    public void setListAnio(List listAnio) {
        this.listAnio = listAnio;
    }

    public List getListSemestre() {
        return listSemestre;
    }

    public void setListSemestre(List listSemestre) {
        this.listSemestre = listSemestre;
    }

    public List getListAula() {
        return listAula;
    }

    public void setListAula(List listAula) {
        this.listAula = listAula;
    }

    public List getListDia() {
        return listDia;
    }

    public void setListDia(List listDia) {
        this.listDia = listDia;
    }

    public List getListHora() {
        return listHora;
    }

    public void setListHora(List listHora) {
        this.listHora = listHora;
    }

    public List getListDuracion() {
        return listDuracion;
    }

    public void setListDuracion(List listDuracion) {
        this.listDuracion = listDuracion;
    }

    public List getListCursoSemestre() {
        return listCursoSemestre;
    }

    public void setListCursoSemestre(List listCursoSemestre) {
        this.listCursoSemestre = listCursoSemestre;
    }

    public String getSelAnio() {
        return selAnio;
    }

    public void setSelAnio(String selAnio) {
        this.selAnio = selAnio;
    }

    public String getSelSemestre() {
        return selSemestre;
    }

    public void setSelSemestre(String selSemestre) {
        this.selSemestre = selSemestre;
    }

    public String getSelAula() {
        return selAula;
    }

    public void setSelAula(String selAula) {
        this.selAula = selAula;
    }

    public String getSelDia() {
        return selDia;
    }

    public void setSelDia(String selDia) {
        this.selDia = selDia;
    }

    public String getSelHoraInicio() {
        return selHoraInicio;
    }

    public void setSelHoraInicio(String selHoraInicio) {
        this.selHoraInicio = selHoraInicio;
    }

    public String getSelDuracion() {
        return selDuracion;
    }

    public void setSelDuracion(String selDuracion) {
        this.selDuracion = selDuracion;
    }

    public String getSelcursoSemestre() {
        return selcursoSemestre;
    }

    public void setSelcursoSemestre(String selcursoSemestre) {
        this.selcursoSemestre = selcursoSemestre;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    public String getRep_horaInicio() {
        return rep_horaInicio;
    }

    public void setRep_horaInicio(String rep_horaInicio) {
        this.rep_horaInicio = rep_horaInicio;
    }

    public String getRep_horaFin() {
        return rep_horaFin;
    }

    public void setRep_horaFin(String rep_horaFin) {
        this.rep_horaFin = rep_horaFin;
    }

    public String getRep_lunes() {
        return rep_lunes;
    }

    public void setRep_lunes(String rep_lunes) {
        this.rep_lunes = rep_lunes;
    }

    public String getRep_martes() {
        return rep_martes;
    }

    public void setRep_martes(String rep_martes) {
        this.rep_martes = rep_martes;
    }

    public String getRep_miercoles() {
        return rep_miercoles;
    }

    public void setRep_miercoles(String rep_miercoles) {
        this.rep_miercoles = rep_miercoles;
    }

    public String getRep_jueves() {
        return rep_jueves;
    }

    public void setRep_jueves(String rep_jueves) {
        this.rep_jueves = rep_jueves;
    }

    public String getRep_viernes() {
        return rep_viernes;
    }

    public void setRep_viernes(String rep_viernes) {
        this.rep_viernes = rep_viernes;
    }

    public String getRep_sabado() {
        return rep_sabado;
    }

    public void setRep_sabado(String rep_sabado) {
        this.rep_sabado = rep_sabado;
    }

    public String getRep_lunes_dur() {
        return rep_lunes_dur;
    }

    public void setRep_lunes_dur(String rep_lunes_dur) {
        this.rep_lunes_dur = rep_lunes_dur;
    }

    public String getRep_martes_dur() {
        return rep_martes_dur;
    }

    public void setRep_martes_dur(String rep_martes_dur) {
        this.rep_martes_dur = rep_martes_dur;
    }

    public String getRep_miercoles_dur() {
        return rep_miercoles_dur;
    }

    public void setRep_miercoles_dur(String rep_miercoles_dur) {
        this.rep_miercoles_dur = rep_miercoles_dur;
    }

    public String getRep_jueves_dur() {
        return rep_jueves_dur;
    }

    public void setRep_jueves_dur(String rep_jueves_dur) {
        this.rep_jueves_dur = rep_jueves_dur;
    }

    public String getRep_viernes_dur() {
        return rep_viernes_dur;
    }

    public void setRep_viernes_dur(String rep_viernes_dur) {
        this.rep_viernes_dur = rep_viernes_dur;
    }

    public String getRep_sabado_dur() {
        return rep_sabado_dur;
    }

    public void setRep_sabado_dur(String rep_sabado_dur) {
        this.rep_sabado_dur = rep_sabado_dur;
    }

    public String getRep_lunes_docente() {
        return rep_lunes_docente;
    }

    public void setRep_lunes_docente(String rep_lunes_docente) {
        this.rep_lunes_docente = rep_lunes_docente;
    }

    public String getRep_martes_docente() {
        return rep_martes_docente;
    }

    public void setRep_martes_docente(String rep_martes_docente) {
        this.rep_martes_docente = rep_martes_docente;
    }

    public String getRep_miercoles_docente() {
        return rep_miercoles_docente;
    }

    public void setRep_miercoles_docente(String rep_miercoles_docente) {
        this.rep_miercoles_docente = rep_miercoles_docente;
    }

    public String getRep_jueves_docente() {
        return rep_jueves_docente;
    }

    public void setRep_jueves_docente(String rep_jueves_docente) {
        this.rep_jueves_docente = rep_jueves_docente;
    }

    public String getRep_viernes_docente() {
        return rep_viernes_docente;
    }

    public void setRep_viernes_docente(String rep_viernes_docente) {
        this.rep_viernes_docente = rep_viernes_docente;
    }

    public String getRep_sabado_docente() {
        return rep_sabado_docente;
    }

    public void setRep_sabado_docente(String rep_sabado_docente) {
        this.rep_sabado_docente = rep_sabado_docente;
    }

}