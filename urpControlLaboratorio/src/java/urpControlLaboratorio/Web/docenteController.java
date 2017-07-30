
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
        
        Docente docente = new Docente();
        docente.setTipoAccion("Ingresar los Datos del Docente");
        docente.setBotonAccion("Ingresar");        
        return new ModelAndView("docente","model", docente);
    }
    
    @RequestMapping(value="insertarDocente.htm",method= RequestMethod.POST)
    public ModelAndView insertarDocente(HttpServletRequest request, Docente docente){ 
        
        
        Docente docente_form = new Docente();
        
        String resultado = docentesManager.insertDocente(docente);  
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroDocente.htm");
            
        } else{
            
            docente_form.setTipoAccion("Ingresar los Datos del Docente");
            docente_form.setBotonAccion("Ingresar");
            docente_form.setCoddocente(request.getParameter("coddocente"));
            docente_form.setNombres(request.getParameter("nombres"));
            docente_form.setApellidos(request.getParameter("apellidos"));
            docente_form.setPassword(request.getParameter("password"));
            
            docente_form.setMsgError(resultado);
            
            return new ModelAndView("docente","model", docente_form);
        }

    }
    
    
    
    @RequestMapping(value="editarDocente.htm",method= RequestMethod.GET)
    public ModelAndView editarDocente(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Docente docente = docentesManager.getDocente(request.getParameter("id"));
        docente.setTipoAccion("Editar Datos del Docente");
        docente.setBotonAccion("Actualizar");
        return new ModelAndView("docente","model", docente);
    }
    
    
    @RequestMapping(value="editarDocente.htm",method= RequestMethod.POST)
    public ModelAndView editarDocente(Docente docente, HttpServletRequest request){ 
        
        String resultado = docentesManager.updateDocente(docente, request.getParameter("id"));
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroDocente.htm");
            
        } else{
            
            Docente docente_upd = docentesManager.getDocente(request.getParameter("id"));
            docente_upd.setTipoAccion("Editar Datos del Docente");
            docente_upd.setBotonAccion("Actualizar");
            
            docente_upd.setCoddocente(request.getParameter("coddocente"));
            docente_upd.setNombres(request.getParameter("nombres"));
            docente_upd.setApellidos(request.getParameter("apellidos"));
            docente_upd.setPassword(request.getParameter("password"));
            
            docente_upd.setMsgError(resultado);
            
            return new ModelAndView("docente","model", docente_upd);
        }

    }
    
    
    
    
    @RequestMapping(value="eliminarDocente.htm",method= RequestMethod.GET)
    public ModelAndView eliminarDocente(HttpServletRequest request){ 

        docentesManager.deleteDocente(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroDocente.htm");
    }
 
}
