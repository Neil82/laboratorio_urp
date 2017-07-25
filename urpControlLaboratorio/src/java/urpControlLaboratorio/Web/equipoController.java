package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView insertarEquipo(HttpServletRequest request, Equipo equipo){ 

        Equipo equipo_form = new Equipo();
        
        String resultado = equiposManager.insertEquipo(equipo);
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroEquipo.htm");
            
        } else{
            
            equipo_form.setTipoAccion("Ingresar los Datos del Equipo");
            equipo_form.setBotonAccion("Ingresar");
            
            equipo_form.setEqnombre(request.getParameter("eqnombre"));
            
            List listAulas = this.aulasManager.getAulas();
            equipo_form.setListAula(listAulas);
            equipo_form.setSelAula(request.getParameter("idaula"));
            
            equipo_form.setCpu_marca(request.getParameter("cpu_marca"));
            equipo_form.setCpu_modelo(request.getParameter("cpu_modelo"));
            equipo_form.setCpu_serie(request.getParameter("cpu_serie"));
            
            equipo_form.setProcesador(request.getParameter("procesador"));
            equipo_form.setVelocidad(request.getParameter("velocidad"));
            equipo_form.setRam(request.getParameter("ram"));
            equipo_form.setDisco_d(request.getParameter("disco_d"));
            equipo_form.setTvideo(request.getParameter("tvideo"));
            
            equipo_form.setMonitor_marca(request.getParameter("monitor_marca"));
            equipo_form.setMonitor_modelo(request.getParameter("monitor_modelo"));
            equipo_form.setMonitor_serie(request.getParameter("monitor_serie"));
            
            equipo_form.setTeclado_marca(request.getParameter("teclado_marca"));
            equipo_form.setTeclado_modelo(request.getParameter("teclado_modelo"));
            equipo_form.setTeclado_serie(request.getParameter("teclado_serie"));
            
            equipo_form.setMouse_marca(request.getParameter("mouse_marca"));
            equipo_form.setMouse_modelo(request.getParameter("mouse_modelo"));
            equipo_form.setMouse_serie(request.getParameter("mouse_serie"));
            
            equipo_form.setMsgError(resultado);
            
            return new ModelAndView("equipo","model", equipo_form);
        }
   
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
        
        String resultado = equiposManager.updateEquipo(equipo, request.getParameter("id"));
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroEquipo.htm");
            
        } else{
            
            Equipo equipo_upd = equiposManager.getEquipo(request.getParameter("id"));
            equipo_upd.setTipoAccion("Editar Datos del Equipo");
            equipo_upd.setBotonAccion("Actualizar");
            
            equipo_upd.setEqnombre(request.getParameter("eqnombre"));
            
            List listAulas = this.aulasManager.getAulas();
            equipo_upd.setListAula(listAulas);
            equipo_upd.setSelAula(request.getParameter("idaula"));
            
            equipo_upd.setCpu_marca(request.getParameter("cpu_marca"));
            equipo_upd.setCpu_modelo(request.getParameter("cpu_modelo"));
            equipo_upd.setCpu_serie(request.getParameter("cpu_serie"));
            
            equipo_upd.setProcesador(request.getParameter("procesador"));
            equipo_upd.setVelocidad(request.getParameter("velocidad"));
            equipo_upd.setRam(request.getParameter("ram"));
            equipo_upd.setDisco_d(request.getParameter("disco_d"));
            equipo_upd.setTvideo(request.getParameter("tvideo"));
            
            equipo_upd.setMonitor_marca(request.getParameter("monitor_marca"));
            equipo_upd.setMonitor_modelo(request.getParameter("monitor_modelo"));
            equipo_upd.setMonitor_serie(request.getParameter("monitor_serie"));
            
            equipo_upd.setTeclado_marca(request.getParameter("teclado_marca"));
            equipo_upd.setTeclado_modelo(request.getParameter("teclado_modelo"));
            equipo_upd.setTeclado_serie(request.getParameter("teclado_serie"));
            
            equipo_upd.setMouse_marca(request.getParameter("mouse_marca"));
            equipo_upd.setMouse_modelo(request.getParameter("mouse_modelo"));
            equipo_upd.setMouse_serie(request.getParameter("mouse_serie"));
            
            equipo_upd.setMsgError(resultado);
            
            return new ModelAndView("equipo","model", equipo_upd);
        }

    }
    
    
    
    
    @RequestMapping(value="eliminarEquipo.htm",method= RequestMethod.GET)
    public ModelAndView eliminarEquipo(HttpServletRequest request){ 
        
        equiposManager.deleteEquipo(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroEquipo.htm");
    }
 
}
