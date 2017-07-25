
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
        
        Curso curso = new Curso();
        curso.setTipoAccion("Ingresar los Datos del Curso");
        curso.setBotonAccion("Ingresar");      
        return new ModelAndView("curso","model", curso);
    }
    
    @RequestMapping(value="insertarCurso.htm",method= RequestMethod.POST)
    public ModelAndView insertarCurso(HttpServletRequest request, Curso curso){ 
        
        Curso curso_form = new Curso();
        
        String resultado = cursosManager.insertCurso(curso); 
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroCurso.htm");
            
        } else{
            
            curso_form.setTipoAccion("Ingresar los Datos del Curso");
            curso_form.setBotonAccion("Ingresar");
            curso_form.setCodcurso(request.getParameter("codcurso"));
            curso_form.setDescripcion(request.getParameter("descripcion"));
            
            curso_form.setMsgError(resultado);
            
            return new ModelAndView("curso","model", curso_form);
        }
        
    }
    
    
    
    @RequestMapping(value="editarCurso.htm",method= RequestMethod.GET)
    public ModelAndView editarCurso(HttpServletRequest request){ 

        Curso curso = cursosManager.getCurso(request.getParameter("id"));
        curso.setTipoAccion("Editar Datos del Curso");
        curso.setBotonAccion("Actualizar");
        return new ModelAndView("curso","model", curso);
    }
    
    @RequestMapping(value="editarCurso.htm",method= RequestMethod.POST)
    public ModelAndView editarCurso(Curso curso, HttpServletRequest request){ 
        
        String resultado = cursosManager.updateCurso(curso, request.getParameter("id"));
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroCurso.htm");
            
        } else{
            
            Curso curso_upd = cursosManager.getCurso(request.getParameter("id"));
            curso_upd.setTipoAccion("Editar Datos del Curso");
            curso_upd.setBotonAccion("Actualizar");
            
            curso_upd.setCodcurso(request.getParameter("codcurso"));
            curso_upd.setDescripcion(request.getParameter("descripcion"));
            
            curso_upd.setMsgError(resultado);
            
            return new ModelAndView("curso","model", curso_upd);
        }
        
    }
    
    
    
    
    @RequestMapping(value="eliminarCurso.htm",method= RequestMethod.GET)
    public ModelAndView eliminarCurso(HttpServletRequest request){ 
        
        cursosManager.deleteCurso(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCurso.htm");
    }
    
    @RequestMapping(value="eliminarCurso.htm",method= RequestMethod.POST)
    public ModelAndView deleteCurso(Curso curso, HttpServletRequest request){ 
        
        cursosManager.deleteCurso(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCurso.htm");
    }
    
 
}
