package urpControlLaboratorio.Entidades; 
import java.util.List;

public class CursoSemestre { 
    private String id;
    private String id_anio;
    private String id_semestre;
    private String id_curso;
    private String id_grupo;
    private String id_subgrupo;
    private String id_docente;
    private String cursoDocente;
    private List listCurso;
    private List listAnio;
    private List listSemestre;
    private List listGrupo;
    private List listSubGrupo;
    private List listDocente;
    private String selAnio;
    private String selSemestre;
    
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

    public String getId_curso() {
        return id_curso;
    }

    public void setId_curso(String id_curso) {
        this.id_curso = id_curso;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getId_subgrupo() {
        return id_subgrupo;
    }

    public void setId_subgrupo(String id_subgrupo) {
        this.id_subgrupo = id_subgrupo;
    }

    public String getId_docente() {
        return id_docente;
    }

    public void setId_docente(String id_docente) {
        this.id_docente = id_docente;
    }

    public String getCursoDocente() {
        return cursoDocente;
    }

    public void setCursoDocente(String cursoDocente) {
        this.cursoDocente = cursoDocente;
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

    public List getListCurso() {
        return listCurso;
    }

    public void setListCurso(List listCurso) {
        this.listCurso = listCurso;
    }

    public List getListGrupo() {
        return listGrupo;
    }

    public void setListGrupo(List listGrupo) {
        this.listGrupo = listGrupo;
    }

    public List getListSubGrupo() {
        return listSubGrupo;
    }

    public void setListSubGrupo(List listSubGrupo) {
        this.listSubGrupo = listSubGrupo;
    }

    public List getListDocente() {
        return listDocente;
    }

    public void setListDocente(List listDocente) {
        this.listDocente = listDocente;
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
}