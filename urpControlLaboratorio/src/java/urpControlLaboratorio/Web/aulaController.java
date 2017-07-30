
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
        
        Aula aula = new Aula();
        aula.setTipoAccion("Ingresar los Datos del Aula");
        aula.setBotonAccion("Ingresar");        
        return new ModelAndView("aula","model", aula);
    }
    
    @RequestMapping(value="insertarAula.htm",method= RequestMethod.POST)
    public ModelAndView insertarAula(HttpServletRequest request, Aula aula){ 
    
        Aula aula_form = new Aula();
        
        String resultado = aulasManager.insertAula(aula);
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroAula.htm");
            
        } else{
            
            aula_form.setTipoAccion("Ingresar los Datos del Aula");
            aula_form.setBotonAccion("Ingresar");
            aula_form.setAula(request.getParameter("aula"));
            
            aula_form.setMsgError(resultado);
            
            return new ModelAndView("aula","model", aula_form);
        }
    }
    
    
    
    @RequestMapping(value="editarAula.htm",method= RequestMethod.GET)
    public ModelAndView editarAula(HttpServletRequest request){ 
        
        Aula aula = aulasManager.getAula(request.getParameter("id"));
        aula.setTipoAccion("Editar Datos del Aula");
        aula.setBotonAccion("Actualizar");
        return new ModelAndView("aula","model", aula);
    }
    
    
    
    @RequestMapping(value="editarAula.htm",method= RequestMethod.POST)
    public ModelAndView editarAula(Aula aula, HttpServletRequest request){ 
         
        String resultado = aulasManager.updateAula(aula, request.getParameter("id"));
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroAula.htm");
            
        } else{
            
            Aula aula_upd = aulasManager.getAula(request.getParameter("id"));
            aula_upd.setTipoAccion("Editar Datos del Aula");
            aula_upd.setBotonAccion("Actualizar");
            
            aula_upd.setAula(request.getParameter("aula"));
            
            aula_upd.setMsgError(resultado);
            
            return new ModelAndView("aula","model", aula_upd);
        }

    }
    
    
    
    
    @RequestMapping(value="eliminarAula.htm",method= RequestMethod.GET)
    public ModelAndView eliminarAula(HttpServletRequest request){ 
        
        aulasManager.deleteAula(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAula.htm");
    }
    
   
}
