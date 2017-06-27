
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
import urpControlLaboratorio.Entidades.Anio;
import urpControlLaboratorio.Negocio.AnioNegocio;
import urpControlLaboratorio.Negocio.AnioValidator;

public class anioController {
    
    private AnioNegocio aniosManager = new AnioNegocio(); 
    private AnioValidator aniosValidador;
    
    public anioController(){
  
        this.aniosValidador = new AnioValidator();
    }
    
    public void setAniosManager(AnioNegocio aniosManager) {
        this.aniosManager = aniosManager;
    } 
    
    @RequestMapping("maestroAnio.htm")
    public ModelAndView maestroAnios(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("anios", this.aniosManager.getAnios());         
        return new ModelAndView("maestroAnio","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarAnio.htm",method= RequestMethod.GET)
    public ModelAndView insertarAnio(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("anio","model", new Anio());
    }
    
    @RequestMapping(value="insertarAnio.htm",method= RequestMethod.POST)
    public ModelAndView insertarAnio(Anio anio){ 
        Errors errors = null;
        
        //this.aniosValidador.validate(anio, errors);
        aniosManager.insertAnio(anio); 
        return new ModelAndView("redirect:/maestroAnio.htm");
    }
    
    
    
    @RequestMapping(value="editarAnio.htm",method= RequestMethod.GET)
    public ModelAndView editarAnio(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Anio anio = aniosManager.getAnio(request.getParameter("id"));
        return new ModelAndView("anio","model", anio);
    }
    
    @RequestMapping(value="editarAnio.htm",method= RequestMethod.POST)
    public ModelAndView editarAnio(Anio anio, HttpServletRequest request){ 
        
        aniosManager.updateAnio(anio, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAnio.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarAnio.htm",method= RequestMethod.GET)
    public ModelAndView eliminarAnio(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        Anio anio = aniosManager.getAnio(request.getParameter("id"));
        return new ModelAndView("anio","model", anio);*/
        
        aniosManager.deleteAnio(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAnio.htm");
    }
    
    @RequestMapping(value="eliminarAnio.htm",method= RequestMethod.POST)
    public ModelAndView deleteAnio(Anio anio, HttpServletRequest request){ 
        
        aniosManager.deleteAnio(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAnio.htm");
    }
    
 
}
