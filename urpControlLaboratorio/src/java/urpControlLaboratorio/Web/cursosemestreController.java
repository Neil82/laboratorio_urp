
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import urpControlLaboratorio.Entidades.CursoSemestre;
import urpControlLaboratorio.Negocio.AnioNegocio;
import urpControlLaboratorio.Negocio.CursoNegocio;
import urpControlLaboratorio.Negocio.CursoSemestreNegocio;
import urpControlLaboratorio.Negocio.CursoSemestreValidator;
import urpControlLaboratorio.Negocio.DocenteNegocio;
import urpControlLaboratorio.Negocio.GrupoNegocio;
import urpControlLaboratorio.Negocio.SemestreNegocio;
import urpControlLaboratorio.Negocio.SubGrupoNegocio;

public class cursosemestreController {
    
    private CursoSemestreNegocio cursoSemestresManager = new CursoSemestreNegocio(); 
    private final CursoNegocio cursosManager = new CursoNegocio(); 
    private final AnioNegocio aniosManager = new AnioNegocio(); 
    private final SemestreNegocio semestresManager = new SemestreNegocio(); 
    private final GrupoNegocio gruposManager = new GrupoNegocio();
    private final SubGrupoNegocio subgruposManager = new SubGrupoNegocio();
    private final DocenteNegocio docentesManager = new DocenteNegocio();
    private final CursoSemestreValidator cursoSemestresValidador;
    
    public cursosemestreController(){
  
        this.cursoSemestresValidador = new CursoSemestreValidator();
    }
    
    public void setCursoSemestresManager(CursoSemestreNegocio cursoSemestresManager) {
        this.cursoSemestresManager = cursoSemestresManager;
    } 
    
    @RequestMapping("maestroCursoSemestre.htm")
    public ModelAndView maestroCursoSemestres(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        //myModel.put("cursoSemestres", this.cursoSemestresManager.getCursoSemestres()); 
        myModel.put("anios", this.aniosManager.getAnios());  
        myModel.put("semestres", this.semestresManager.getSemestres());
        return new ModelAndView("maestroCursoSemestre","model", myModel);
    }
    
    
    @RequestMapping(value="maestroCursoSemestreAccion.htm",method= RequestMethod.GET)
    public ModelAndView maestroCursoSemestreAccion(HttpServletRequest request){
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("cursoSemestres", this.cursoSemestresManager.getCursoSemestreAjax(request.getParameter("selAnio"), request.getParameter("selSemestre")));  
        return new ModelAndView("maestroCursoSemestre_Accion","model", myModel);
    }
    
    
 
    
    @RequestMapping(value="addCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView addCursoSemestre(HttpServletRequest request, CursoSemestre cursoSemestre){ 
        Errors errors = null;

        //Map<String, Object> myModel = new HashMap<String, Object>();
        
        List listAnios = this.aniosManager.getAnios(); 
        List listSemestres = this.semestresManager.getSemestres();
        List listCursos = this.cursosManager.getCursos();
        List listGrupos = this.gruposManager.getGrupos();
        List listSubGrupos = this.subgruposManager.getSubGrupos();
        List listDocentes = this.docentesManager.getDocentes();

        CursoSemestre cursosemestre = new CursoSemestre();
        cursosemestre.setSelAnio(request.getParameter("selAnio"));
        cursosemestre.setSelSemestre(request.getParameter("selSemestre"));
        cursosemestre.setListAnio(listAnios);
        cursosemestre.setListSemestre(listSemestres);
        cursosemestre.setListCurso(listCursos);
        cursosemestre.setListGrupo(listGrupos);
        cursosemestre.setListSubGrupo(listSubGrupos);
        cursosemestre.setListDocente(listDocentes);
        cursosemestre.setTipoAccion("Ingresar los Datos del Curso-Semestre");
        cursosemestre.setBotonAccion("Ingresar");       
        return new ModelAndView("cursoSemestre","model", cursosemestre);
    }
    
    @RequestMapping(value="insertarCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView insertarCursoSemestre(CursoSemestre cursoSemestre){ 
        Errors errors = null;
        
        //this.cursoSemestresValidador.validate(cursoSemestre, errors);
        cursoSemestresManager.insertCursoSemestre(cursoSemestre); 
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    
    
    
    @RequestMapping(value="editarCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView editarCursoSemestre(HttpServletRequest request){ 
           
        CursoSemestre cursoSemestre = cursoSemestresManager.getCursoSemestre(request.getParameter("id"));
        
        List listAnios = this.aniosManager.getAnios(); 
        List listSemestres = this.semestresManager.getSemestres();
        List listCursos = this.cursosManager.getCursos();
        List listGrupos = this.gruposManager.getGrupos();
        List listSubGrupos = this.subgruposManager.getSubGrupos();
        List listDocentes = this.docentesManager.getDocentes();

         CursoSemestre cursosemestre = new CursoSemestre();
         
         cursosemestre.setSelAnio(cursoSemestre.getId_anio());
         cursosemestre.setSelSemestre(cursoSemestre.getId_semestre());
         cursosemestre.setSelCurso(cursoSemestre.getId_curso());
         cursosemestre.setSelGrupo(cursoSemestre.getId_grupo());
         cursosemestre.setSelSubgrupo(cursoSemestre.getId_subgrupo());
         cursosemestre.setSelDocente(cursoSemestre.getId_docente());
         
         cursosemestre.setListAnio(listAnios);
         cursosemestre.setListSemestre(listSemestres);
         cursosemestre.setListCurso(listCursos);
         cursosemestre.setListGrupo(listGrupos);
         cursosemestre.setListSubGrupo(listSubGrupos);
         cursosemestre.setListDocente(listDocentes);
         
        
        cursosemestre.setTipoAccion("Editar Datos del Curso-Semestre");
        cursosemestre.setBotonAccion("Actualizar");
        return new ModelAndView("cursoSemestre","model", cursosemestre);
    }
    
    @RequestMapping(value="editarCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView editarCursoSemestre(CursoSemestre cursoSemestre, HttpServletRequest request){ 
        
        cursoSemestresManager.updateCursoSemestre(cursoSemestre, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView eliminarCursoSemestre(HttpServletRequest request){ 

        
        cursoSemestresManager.deleteCursoSemestre(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    

}
