
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
import urpControlLaboratorio.Entidades.Horario;
import urpControlLaboratorio.Negocio.AnioNegocio;
import urpControlLaboratorio.Negocio.AulaNegocio;
import urpControlLaboratorio.Negocio.HorarioNegocio;
import urpControlLaboratorio.Negocio.HorarioValidator;
import urpControlLaboratorio.Negocio.SemestreNegocio;

public class horarioController {
    
    private HorarioNegocio horariosManager = new HorarioNegocio(); 
    private AulaNegocio aulasManager = new AulaNegocio(); 
    private AnioNegocio aniosManager = new AnioNegocio(); 
    private SemestreNegocio semestresManager = new SemestreNegocio(); 
    private HorarioValidator horariosValidador;
    
    public horarioController(){
  
        this.horariosValidador = new HorarioValidator();
    }
    
    public void setHorariosManager(HorarioNegocio horariosManager) {
        this.horariosManager = horariosManager;
    } 
    
    @RequestMapping("maestroHorario.htm")
    public ModelAndView maestroHorarios(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("horarios", this.horariosManager.getHorarios()); 
        myModel.put("aulas", this.aulasManager.getAulas());        
        myModel.put("anios", this.aniosManager.getAnios());  
        myModel.put("semestres", this.semestresManager.getSemestres());  
        return new ModelAndView("maestroHorario","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarHorario.htm",method= RequestMethod.GET)
    public ModelAndView insertarHorario(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        return new ModelAndView("horario","model", new Horario());
    }
    
    @RequestMapping(value="insertarHorario.htm",method= RequestMethod.POST)
    public ModelAndView insertarHorario(Horario horario){ 
        Errors errors = null;
        
        //this.horariosValidador.validate(horario, errors);
        horariosManager.insertHorario(horario); 
        return new ModelAndView("redirect:/maestroHorario.htm");
    }
    
    
    
    @RequestMapping(value="editarHorario.htm",method= RequestMethod.GET)
    public ModelAndView editarHorario(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Horario horario = horariosManager.getHorario(request.getParameter("id"));
        return new ModelAndView("horario","model", horario);
    }
    
    @RequestMapping(value="editarHorario.htm",method= RequestMethod.POST)
    public ModelAndView editarHorario(Horario horario, HttpServletRequest request){ 
        
        horariosManager.updateHorario(horario, request.getParameter("id"));
        return new ModelAndView("redirect:/maestroHorario.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarHorario.htm",method= RequestMethod.GET)
    public ModelAndView eliminarHorario(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        Horario horario = horariosManager.getHorario(request.getParameter("id"));
        return new ModelAndView("horario","model", horario);*/
        
        horariosManager.deleteHorario(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroHorario.htm");
    }
    
    @RequestMapping(value="eliminarHorario.htm",method= RequestMethod.POST)
    public ModelAndView deleteHorario(Horario horario, HttpServletRequest request){ 
        
        horariosManager.deleteHorario(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroHorario.htm");
    }
    
 
}
