
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import urpControlLaboratorio.Entidades.Horario;
import urpControlLaboratorio.Negocio.AnioNegocio;
import urpControlLaboratorio.Negocio.AulaNegocio;
import urpControlLaboratorio.Negocio.CursoSemestreNegocio;
import urpControlLaboratorio.Negocio.DiaNegocio;
import urpControlLaboratorio.Negocio.DuracionNegocio;
import urpControlLaboratorio.Negocio.HoraNegocio;
import urpControlLaboratorio.Negocio.HorarioNegocio;
import urpControlLaboratorio.Negocio.HorarioValidator;
import urpControlLaboratorio.Negocio.SemestreNegocio;

public class horarioController {
    
    private HorarioNegocio horariosManager = new HorarioNegocio();
    
    private final AnioNegocio aniosManager = new AnioNegocio(); 
    private final AulaNegocio aulasManager = new AulaNegocio(); 
    private final SemestreNegocio semestresManager = new SemestreNegocio(); 
    private final DiaNegocio diasManager = new DiaNegocio(); 
    private final HoraNegocio horasManager = new HoraNegocio(); 
    private final DuracionNegocio duracionesManager = new DuracionNegocio(); 
    private final CursoSemestreNegocio cursosemestreManager = new CursoSemestreNegocio(); 
    
    private final HorarioValidator horariosValidador;
 
    
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
    
    
    
    
    @RequestMapping(value="addHorario.htm",method= RequestMethod.POST)
    public ModelAndView addHorario(HttpServletRequest request, Horario horario){ 
        Errors errors = null;

        //Map<String, Object> myModel = new HashMap<String, Object>();
        
       List listAnios = this.aniosManager.getAnioForm(request.getParameter("selAnio")); 
       List listSemestres = this.semestresManager.getSemestreForm(request.getParameter("selSemestre"));
       List listAulas = this.aulasManager.getAulasForm(request.getParameter("selAula"));
       List listDias = this.diasManager.getDias();
       List listHoras = this.horasManager.getHoras();
       List listDuracion = this.duracionesManager.getDuracion();
       List listCursoSemestre = this.cursosemestreManager.getCursoSemestreForm(request.getParameter("selAnio"), request.getParameter("selSemestre"));
        
       Horario h = new Horario();
       h.setListAnio(listAnios);
       h.setListSemestre(listSemestres);
       h.setListAula(listAulas);
       h.setListDia(listDias);
       h.setListHora(listHoras);
       h.setListDuracion(listDuracion);
       h.setListCursoSemestre(listCursoSemestre);
        
       return new ModelAndView("horario","model", h);
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
