
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
import urpControlLaboratorio.Entidades.Docente;
import urpControlLaboratorio.Negocio.DocenteNegocio;
import urpControlLaboratorio.Negocio.DocenteValidator;

public class docenteController {
    
    private DocenteNegocio docentesManager = new DocenteNegocio(); 
    private DocenteValidator docentesValidador;
    
    public docenteController(){
  
        this.docentesValidador = new DocenteValidator();
    }
    
    public void setDocentesManager(DocenteNegocio docentesManager) {
        this.docentesManager = docentesManager;
    } 
    
    @RequestMapping("maestroDocente.htm")
    public ModelAndView maestroDocentes(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("docentes", this.docentesManager.getDocentes());         
        return new ModelAndView("maestroDocente","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarDocente.htm",method= RequestMethod.GET)
    public ModelAndView insertarDocente(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("docente","model", new Docente());
    }
    
    @RequestMapping(value="insertarDocente.htm",method= RequestMethod.POST)
    public ModelAndView insertarDocente(Docente docente){ 
        Errors errors = null;
        
        //this.docentesValidador.validate(docente, errors);
        docentesManager.insertDocente(docente); 
        return new ModelAndView("redirect:/maestroDocente.htm");
    }
    
    
    
    @RequestMapping(value="editarDocente.htm",method= RequestMethod.GET)
    public ModelAndView editarDocente(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Docente docente = docentesManager.getDocente(request.getParameter("id"));
        return new ModelAndView("docente","model", docente);
    }
    
    @RequestMapping(value="editarDocente.htm",method= RequestMethod.POST)
    public ModelAndView editarDocente(Docente docente, HttpServletRequest request){ 
        
        docentesManager.updateDocente(docente, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroDocente.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarDocente.htm",method= RequestMethod.GET)
    public ModelAndView eliminarDocente(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        Docente docente = docentesManager.getDocente(request.getParameter("id"));
        return new ModelAndView("docente","model", docente);*/
        
        docentesManager.deleteDocente(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroDocente.htm");
    }
    
    @RequestMapping(value="eliminarDocente.htm",method= RequestMethod.POST)
    public ModelAndView deleteDocente(Docente docente, HttpServletRequest request){ 
        
        docentesManager.deleteDocente(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroDocente.htm");
    }
    
 
}
