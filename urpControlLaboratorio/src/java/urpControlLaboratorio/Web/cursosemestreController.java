
package urpControlLaboratorio.Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
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
        myModel.put("cursoSemestres", this.cursoSemestresManager.getCursoSemestres()); 
        myModel.put("cursos", this.cursosManager.getCursos());        
        myModel.put("anios", this.aniosManager.getAnios());  
        myModel.put("semestres", this.semestresManager.getSemestres());  
        return new ModelAndView("maestroCursoSemestre","model", myModel);
    }
    
    
    
    /*@RequestMapping(value="insertarCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView insertarCursoSemestre(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        CursoSemestre h = new CursoSemestre();
        //h.setId(request.getParameter("id"));
        //h.setAula(request.getParameter("id"));
        return new ModelAndView("cursoSemestre","model", h);
    }*/
    
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
        
        CursoSemestre h = new CursoSemestre();
        h.setSelAnio(request.getParameter("selAnio"));
        h.setSelSemestre(request.getParameter("selSemestre"));
        h.setListAnio(listAnios);
        h.setListSemestre(listSemestres);
        h.setListCurso(listCursos);
        h.setListGrupo(listGrupos);
        h.setListSubGrupo(listSubGrupos);
        h.setListDocente(listDocentes);
        return new ModelAndView("cursoSemestre","model", h);
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
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        CursoSemestre cursoSemestre = cursoSemestresManager.getCursoSemestre(request.getParameter("id"));
        return new ModelAndView("cursoSemestre","model", cursoSemestre);
    }
    
    @RequestMapping(value="editarCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView editarCursoSemestre(CursoSemestre cursoSemestre, HttpServletRequest request){ 
        
        cursoSemestresManager.updateCursoSemestre(cursoSemestre, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView eliminarCursoSemestre(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        CursoSemestre cursoSemestre = cursoSemestresManager.getCursoSemestre(request.getParameter("id"));
        return new ModelAndView("cursoSemestre","model", cursoSemestre);*/
        
        cursoSemestresManager.deleteCursoSemestre(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    
    @RequestMapping(value="eliminarCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView deleteCursoSemestre(CursoSemestre cursoSemestre, HttpServletRequest request){ 
        
        cursoSemestresManager.deleteCursoSemestre(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    
 
}
