
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
import urpControlLaboratorio.Entidades.Aula;
import urpControlLaboratorio.Negocio.AulaNegocio;
import urpControlLaboratorio.Negocio.AulaValidator;

public class aulaController {
    
    private AulaNegocio aulasManager = new AulaNegocio(); 
    private AulaValidator aulasValidador;
    
    public aulaController(){
  
        this.aulasValidador = new AulaValidator();
    }
    
    public void setAulasManager(AulaNegocio aulasManager) {
        this.aulasManager = aulasManager;
    } 
    
    @RequestMapping("maestroAula.htm")
    public ModelAndView maestroAulas(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("aulas", this.aulasManager.getAulas());         
        return new ModelAndView("maestroAula","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarAula.htm",method= RequestMethod.GET)
    public ModelAndView insertarAula(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("aula","model", new Aula());
    }
    
    @RequestMapping(value="insertarAula.htm",method= RequestMethod.POST)
    public ModelAndView insertarAula(Aula aula){ 
        Errors errors = null;
        
        this.aulasValidador.validate(aula, errors);
        aulasManager.insertAula(aula); 
        return new ModelAndView("redirect:/maestroAula.htm");
    }
    
    
    
    @RequestMapping(value="editarAula.htm",method= RequestMethod.GET)
    public ModelAndView editarAula(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Aula aula = aulasManager.getAula(request.getParameter("id"));
        return new ModelAndView("aula","model", aula);
    }
    
    @RequestMapping(value="editarAula.htm",method= RequestMethod.POST)
    public ModelAndView editarAula(Aula aula, HttpServletRequest request){ 
        
        aulasManager.updateAula(aula, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAula.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarAula.htm",method= RequestMethod.GET)
    public ModelAndView eliminarAula(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Aula aula = aulasManager.getAula(request.getParameter("id"));
        return new ModelAndView("aula","model", aula);
    }
    
    @RequestMapping(value="eliminarAula.htm",method= RequestMethod.POST)
    public ModelAndView deleteAula(Aula aula, HttpServletRequest request){ 
        
        aulasManager.deleteAula(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAula.htm");
    }
    
 
}
