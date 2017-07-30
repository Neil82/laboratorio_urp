
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
     
        Usuario usuario = new Usuario();
        usuario.setTipoAccion("Ingresar los Datos del Docente");
        usuario.setBotonAccion("Ingresar");        
        return new ModelAndView("usuario","model", usuario);
    }
    
    
    
    @RequestMapping(value="insertarUsuario.htm",method= RequestMethod.POST)
    public ModelAndView insertarUsuario(HttpServletRequest request, Usuario usuario){ 
      
        Usuario usuario_form = new Usuario();
        
        String resultado = usuariosManager.insertUsuario(usuario); 
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroUsuario.htm");
            
        } else{
            
            usuario_form.setTipoAccion("Ingresar los Datos del Usuario");
            usuario_form.setBotonAccion("Ingresar");
            usuario_form.setNombres(request.getParameter("nombres"));
            usuario_form.setDni(request.getParameter("dni"));
            usuario_form.setUsuario(request.getParameter("usuario"));
            usuario_form.setApellidos(request.getParameter("apellidos"));
            usuario_form.setPassword(request.getParameter("password"));
            
            usuario_form.setMsgError(resultado);
            
            return new ModelAndView("usuario","model", usuario_form);
        }
    }
    
    
    
    @RequestMapping(value="editarUsuario.htm",method= RequestMethod.GET)
    public ModelAndView editarUsuario(HttpServletRequest request){     
    
        Map<String, Object> myModel = new HashMap<String, Object>();
        Usuario usuario = usuariosManager.getUsuario(request.getParameter("idusuario"));
        usuario.setTipoAccion("Editar Datos del Usuario");
        usuario.setBotonAccion("Actualizar");
        return new ModelAndView("usuario","model", usuario);
    }
    
    
    @RequestMapping(value="editarUsuario.htm",method= RequestMethod.POST)
    public ModelAndView editarUsuario(Usuario usuario, HttpServletRequest request){ 
  
        String resultado = usuariosManager.updateUsuario(usuario, request.getParameter("idusuario"));
        
        if(resultado=="ok"){
            
            return new ModelAndView("redirect:/maestroUsuario.htm");
            
        } else{
            
            Usuario usuario_upd = usuariosManager.getUsuario(request.getParameter("idusuario"));
            usuario_upd.setTipoAccion("Editar Datos del Docente");
            usuario_upd.setBotonAccion("Actualizar");
            
            usuario_upd.setDni(request.getParameter("dni"));
            usuario_upd.setNombres(request.getParameter("nombres"));
            usuario_upd.setApellidos(request.getParameter("apellidos"));
            usuario_upd.setUsuario(request.getParameter("usuario"));
            usuario_upd.setPassword(request.getParameter("password"));
            
            usuario_upd.setMsgError(resultado);
            
            return new ModelAndView("usuario","model", usuario_upd);
        }
    }
    
    
    
    
    @RequestMapping(value="eliminarUsuario.htm",method= RequestMethod.GET)
    public ModelAndView eliminarUsuario(HttpServletRequest request){ 
     
        usuariosManager.deleteUsuario(request.getParameter("idusuario"));
        return new ModelAndView("redirect:/maestroUsuario.htm");
    }
    
    @RequestMapping(value="eliminarUsuario.htm",method= RequestMethod.POST)
    public ModelAndView deleteUsuario(Usuario usuario, HttpServletRequest request){ 
        
        usuariosManager.deleteUsuario(request.getParameter("idusuario"));
        return new ModelAndView("redirect:/maestroUsuario.htm");
    }
    
 
}
