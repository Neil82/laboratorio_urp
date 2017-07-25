
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
        
        Anio anio = new Anio();
        anio.setTipoAccion("Ingresar los Datos del Año");
        anio.setBotonAccion("Ingresar");       
        return new ModelAndView("anio","model", anio);
    }
    
    @RequestMapping(value="insertarAnio.htm",method= RequestMethod.POST)
    public ModelAndView insertarAnio(HttpServletRequest request, Anio anio){ 
        
        Anio anio_form = new Anio();
        
        String resultado = aniosManager.insertAnio(anio); 
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroAnio.htm");
            
        } else{
            
            anio_form.setTipoAccion("Ingresar los Datos del Año");
            anio_form.setBotonAccion("Ingresar");
            anio_form.setAnio(request.getParameter("anio"));
            anio_form.setDescripcion(request.getParameter("descripcion"));
            
            anio_form.setMsgError(resultado);
            
            return new ModelAndView("anio","model", anio_form);
        }
    }
    
    
    
    @RequestMapping(value="editarAnio.htm",method= RequestMethod.GET)
    public ModelAndView editarAnio(HttpServletRequest request){ 
        
        Anio anio = aniosManager.getAnio(request.getParameter("id"));
        anio.setTipoAccion("Editar Datos del Año");
        anio.setBotonAccion("Actualizar");
        return new ModelAndView("anio","model", anio);
    }
    
    @RequestMapping(value="editarAnio.htm",method= RequestMethod.POST)
    public ModelAndView editarAnio(Anio anio, HttpServletRequest request){ 
        
        String resultado = aniosManager.updateAnio(anio, request.getParameter("id"));
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroAnio.htm");
            
        } else{
            
            Anio anio_upd = aniosManager.getAnio(request.getParameter("id"));
            anio_upd.setTipoAccion("Editar Datos del Año");
            anio_upd.setBotonAccion("Actualizar");
            
            anio_upd.setAnio(request.getParameter("anio"));
            anio_upd.setDescripcion(request.getParameter("descripcion"));
            
            anio_upd.setMsgError(resultado);
            
            return new ModelAndView("anio","model", anio_upd);
        }
      
    }
    
    
    
    
    @RequestMapping(value="eliminarAnio.htm",method= RequestMethod.GET)
    public ModelAndView eliminarAnio(HttpServletRequest request){ 
        
        aniosManager.deleteAnio(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroAnio.htm");
    }

 
}
