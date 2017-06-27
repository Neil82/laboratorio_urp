
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
import urpControlLaboratorio.Entidades.Usuario;
import urpControlLaboratorio.Negocio.UsuarioNegocio;
import urpControlLaboratorio.Negocio.UsuarioValidator;

public class usuarioController {
    
    private UsuarioNegocio usuariosManager = new UsuarioNegocio(); 
    private UsuarioValidator usuariosValidador;
    
    public usuarioController(){
  
        this.usuariosValidador = new UsuarioValidator();
    }
    
    public void setUsuariosManager(UsuarioNegocio usuariosManager) {
        this.usuariosManager = usuariosManager;
    } 
    
    @RequestMapping("maestroUsuario.htm")
    public ModelAndView maestroUsuarios(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("usuarios", this.usuariosManager.getUsuarios());         
        return new ModelAndView("maestroUsuario","model", myModel);
    }
    
    
    
    
    @RequestMapping(value="insertarUsuario.htm",method= RequestMethod.GET)
    public ModelAndView insertarUsuario(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("usuario","model", new Usuario());
    }
    
    @RequestMapping(value="insertarUsuario.htm",method= RequestMethod.POST)
    public ModelAndView insertarUsuario(Usuario usuario){ 
        Errors errors = null;
        
        //this.usuariosValidador.validate(usuario, errors);
        usuariosManager.insertUsuario(usuario); 
        return new ModelAndView("redirect:/maestroUsuario.htm");
    }
    
    
    
    @RequestMapping(value="editarUsuario.htm",method= RequestMethod.GET)
    public ModelAndView editarUsuario(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        Usuario usuario = usuariosManager.getUsuario(request.getParameter("idusuario"));
        return new ModelAndView("usuario","model", usuario);
    }
    
    @RequestMapping(value="editarUsuario.htm",method= RequestMethod.POST)
    public ModelAndView editarUsuario(Usuario usuario, HttpServletRequest request){ 
        
        usuariosManager.updateUsuario(usuario, request.getParameter("idusuario"));
        return new ModelAndView("redirect:/maestroUsuario.htm");
    }
    
    
    
    
    @RequestMapping(value="eliminarUsuario.htm",method= RequestMethod.GET)
    public ModelAndView eliminarUsuario(HttpServletRequest request){ 
        
        /*Map<String, Object> myModel = new HashMap<String, Object>();
        Usuario usuario = usuariosManager.getUsuario(request.getParameter("id"));
        return new ModelAndView("usuario","model", usuario);*/
        
        usuariosManager.deleteUsuario(request.getParameter("idusuario"));
        return new ModelAndView("redirect:/maestroUsuario.htm");
    }
    
    @RequestMapping(value="eliminarUsuario.htm",method= RequestMethod.POST)
    public ModelAndView deleteUsuario(Usuario usuario, HttpServletRequest request){ 
        
        usuariosManager.deleteUsuario(request.getParameter("idusuario"));
        return new ModelAndView("redirect:/maestroUsuario.htm");
    }
    
 
}
