package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import urpControlLaboratorio.Entidades.Equipo;
import urpControlLaboratorio.Negocio.AulaNegocio;
import urpControlLaboratorio.Negocio.EquipoNegocio;
import urpControlLaboratorio.Negocio.EquipoValidator;

public class equipoController {
    
    private EquipoNegocio equiposManager = new EquipoNegocio(); 
    private final EquipoValidator equiposValidador;
    private final AulaNegocio aulasManager = new AulaNegocio(); 
    
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
        
        List listAulas = this.aulasManager.getAulas();
        //Map<String, Object> myModel = new HashMap<String, Object>();
        Equipo equipo = new Equipo(); 
        equipo.setListAula(listAulas);
        equipo.setTipoAccion("Ingresar los Datos del Equipo");
        equipo.setBotonAccion("Ingresar");
        return new ModelAndView("equipo","model", equipo);
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
        
        Equipo equipo = equiposManager.getEquipo(request.getParameter("id"));
        equipo.setTipoAccion("Editar Datos del Equipo");
        equipo.setBotonAccion("Actualizar");
        
        List listAulas = this.aulasManager.getAulas();
        equipo.setListAula(listAulas);
        
        equipo.setSelAula(equipo.getIdaula());
      
        return new ModelAndView("equipo","model", equipo);
    }
    
    @RequestMapping(value="editarEquipo.htm",method= RequestMethod.POST)
    public ModelAndView editarEquipo(Equipo equipo, HttpServletRequest request){ 
        
        equiposManager.updateEquipo(equipo, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarEquipo.htm",method= RequestMethod.GET)
    public ModelAndView eliminarEquipo(HttpServletRequest request){ 
        
        equiposManager.deleteEquipo(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
 
}
