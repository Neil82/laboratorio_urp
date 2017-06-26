
package urpControlLaboratorio.Web;

import java.io.IOException;
import java.util.HashMap;
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
import urpControlLaboratorio.Entidades.Curso;
import urpControlLaboratorio.Negocio.CursoNegocio;
import urpControlLaboratorio.Negocio.CursoValidator;

public class cursoController {
    
    private CursoNegocio cursosManager = new CursoNegocio(); 
    private CursoValidator cursosValidador;
    
    public cursoController(){
  
        this.cursosValidador = new CursoValidator();
    }
    
    public void setCursosManager(CursoNegocio cursosManager) {
        this.cursosManager = cursosManager;
    } 
    
    @RequestMapping("maestroCurso.htm")
    public ModelAndView maestroCursos(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("cursos", this.cursosManager.getCursos());         
        return new ModelAndView("maestroCurso","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarCurso.htm",method= RequestMethod.GET)
    public ModelAndView insertarCurso(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("curso","model", new Curso());
    }
    
    @RequestMapping(value="insertarCurso.htm",method= RequestMethod.POST)
    public ModelAndView insertarCurso(Curso curso){ 
        Errors errors = null;
        
        //this.cursosValidador.validate(curso, errors);
        cursosManager.insertCurso(curso); 
        return new ModelAndView("redirect:/maestroCurso.htm");
    }
    
    
    
    @RequestMapping(value="editarCurso.htm",method= RequestMethod.GET)
    public ModelAndView editarCurso(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Curso curso = cursosManager.getCurso(request.getParameter("id"));
        return new ModelAndView("curso","model", curso);
    }
    
    @RequestMapping(value="editarCurso.htm",method= RequestMethod.POST)
    public ModelAndView editarCurso(Curso curso, HttpServletRequest request){ 
        
        cursosManager.updateCurso(curso, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCurso.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarCurso.htm",method= RequestMethod.GET)
    public ModelAndView eliminarCurso(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        Curso curso = cursosManager.getCurso(request.getParameter("id"));
        return new ModelAndView("curso","model", curso);*/
        
        cursosManager.deleteCurso(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCurso.htm");
    }
    
    @RequestMapping(value="eliminarCurso.htm",method= RequestMethod.POST)
    public ModelAndView deleteCurso(Curso curso, HttpServletRequest request){ 
        
        cursosManager.deleteCurso(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCurso.htm");
    }
    
 
}
