package urpControlLaboratorio.Entidades; 
import java.io.Serializable;
import java.util.List;

public class Horario { 
    private String id;
    private String id_anio;
    private String id_semestre;
    private String id_aula;
    private String id_dia;
    private String id_hinicio;
    private String id_duracion;
    private String id_cursosemestre;
    private List listAnio;
    private List listSemestre;
    private List listAula;
    private List listDia;
    private List listHora;
    private List listDuracion;
    private List listCursoSemestre;
    
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

   
    
}