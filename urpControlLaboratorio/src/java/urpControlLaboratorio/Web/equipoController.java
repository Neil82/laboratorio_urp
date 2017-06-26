
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
import urpControlLaboratorio.Entidades.Equipo;
import urpControlLaboratorio.Negocio.EquipoNegocio;
import urpControlLaboratorio.Negocio.EquipoValidator;

public class equipoController {
    
    private EquipoNegocio equiposManager = new EquipoNegocio(); 
    private EquipoValidator equiposValidador;
    
    public equipoController(){
  
        this.equiposValidador = new EquipoValidator();
    }
    
    public void setEquiposManager(EquipoNegocio equiposManager) {
        this.equiposManager = equiposManager;
    } 
    
    @RequestMapping("maestroEquipo.htm")
    public ModelAndView maestroEquipos(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("equipos", this.equiposManager.getEquipos());         
        return new ModelAndView("maestroEquipo","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarEquipo.htm",method= RequestMethod.GET)
    public ModelAndView insertarEquipo(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("equipo","model", new Equipo());
    }
    
    @RequestMapping(value="insertarEquipo.htm",method= RequestMethod.POST)
    public ModelAndView insertarEquipo(Equipo equipo){ 
        Errors errors = null;
        
        //this.equiposValidador.validate(equipo, errors);
        equiposManager.insertEquipo(equipo); 
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
    
    
    
    @RequestMapping(value="editarEquipo.htm",method= RequestMethod.GET)
    public ModelAndView editarEquipo(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Equipo equipo = equiposManager.getEquipo(request.getParameter("id"));
        return new ModelAndView("equipo","model", equipo);
    }
    
    @RequestMapping(value="editarEquipo.htm",method= RequestMethod.POST)
    public ModelAndView editarEquipo(Equipo equipo, HttpServletRequest request){ 
        
        equiposManager.updateEquipo(equipo, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarEquipo.htm",method= RequestMethod.GET)
    public ModelAndView eliminarEquipo(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        Equipo equipo = equiposManager.getEquipo(request.getParameter("id"));
        return new ModelAndView("equipo","model", equipo);*/
        
        equiposManager.deleteEquipo(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
    
    @RequestMapping(value="eliminarEquipo.htm",method= RequestMethod.POST)
    public ModelAndView deleteEquipo(Equipo equipo, HttpServletRequest request){ 
        
        equiposManager.deleteEquipo(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
    
 
}
