
package urpControlLaboratorio.Web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import urpControlLaboratorio.Entidades.Usuario;
import urpControlLaboratorio.Negocio.LoginNegocio;

public class loginController {
    
    private LoginNegocio loginManager = new LoginNegocio(); 
    
    public void setLoginManager(LoginNegocio loginManager) {
        this.loginManager = loginManager;
    } 
    
    @RequestMapping(value="login.htm",method= RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request){ 
        
        Map<String, Object> myModel = new HashMap<String, Object>();
                
        return new ModelAndView("login","model", new Usuario());
    }
    
    @RequestMapping(value="login.htm",method= RequestMethod.POST)
    public ModelAndView login(Usuario usuario){ 
        try{
            loginManager.comprobarCredenciales(usuario); 
            return new ModelAndView("redirect:/maestroAula.htm");
       }catch (Exception e){
           return new ModelAndView("redirect:/login.htm"); 
           //return new ModelAndView("redirect:/maestroAula.htm");
       }
    }
        
}
