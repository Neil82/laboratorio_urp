
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import urpControlLaboratorio.Entidades.MarcacionDocente;
import urpControlLaboratorio.Negocio.MarcacionNegocio;

public class salidamanualController {
    
    private MarcacionNegocio marcacionManager = new MarcacionNegocio();
    
    public void setMarcacionManager(MarcacionNegocio marcacionManager) {
        this.marcacionManager = marcacionManager;
    } 
    
    @RequestMapping(value="maestroSalidaManual.htm",method= RequestMethod.GET)
    public ModelAndView maestroSalidaManual(HttpServletRequest request){
 
        MarcacionDocente marcacion = new MarcacionDocente();
        marcacion.setId_docente(request.getParameter("id"));

        return new ModelAndView("maestroSalidaManual","model", marcacion);
        
    }
    
    
    @RequestMapping(value="maestroSalidaManual_Accion.htm",method= RequestMethod.GET)
    public ModelAndView maestroSalidaManualAccion(HttpServletRequest request){
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("marcaciones", this.marcacionManager.getMarcaciones(request.getParameter("selUsuarioDocente")));  
        return new ModelAndView("maestroSalidaManual_Accion","model", myModel);
    }
    

    @RequestMapping(value="finalizarMarcacion.htm",method= RequestMethod.GET)
    public ModelAndView marcarSalida(HttpServletRequest request){ 

        marcacionManager.finalizarMarcacion(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroSalidaManual.htm");
    }
    
}
