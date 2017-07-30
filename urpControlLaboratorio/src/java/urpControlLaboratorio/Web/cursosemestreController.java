
package urpControlLaboratorio.Web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import urpControlLaboratorio.Entidades.CursoSemestre;
import urpControlLaboratorio.Negocio.AnioNegocio;
import urpControlLaboratorio.Negocio.CursoNegocio;
import urpControlLaboratorio.Negocio.CursoSemestreNegocio;
import urpControlLaboratorio.Negocio.CursoSemestreValidator;
import urpControlLaboratorio.Negocio.DocenteNegocio;
import urpControlLaboratorio.Negocio.GrupoNegocio;
import urpControlLaboratorio.Negocio.SemestreNegocio;
import urpControlLaboratorio.Negocio.SubGrupoNegocio;

public class cursosemestreController {
    
    private CursoSemestreNegocio cursoSemestresManager = new CursoSemestreNegocio(); 
    private final CursoNegocio cursosManager = new CursoNegocio(); 
    private final AnioNegocio aniosManager = new AnioNegocio(); 
    private final SemestreNegocio semestresManager = new SemestreNegocio(); 
    private final GrupoNegocio gruposManager = new GrupoNegocio();
    private final SubGrupoNegocio subgruposManager = new SubGrupoNegocio();
    private final DocenteNegocio docentesManager = new DocenteNegocio();
    private final CursoSemestreValidator cursoSemestresValidador;
    
    public cursosemestreController(){
  
        this.cursoSemestresValidador = new CursoSemestreValidator();
    }
    
    public void setCursoSemestresManager(CursoSemestreNegocio cursoSemestresManager) {
        this.cursoSemestresManager = cursoSemestresManager;
    } 
    
    @RequestMapping(value="maestroCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView maestroCursoSemestres(HttpServletRequest request){ 
 
        List listAnios = this.aniosManager.getAnios(); 
        List listSemestres = this.semestresManager.getSemestres();
       
        CursoSemestre Mymodel = new CursoSemestre();
        Mymodel.setListAnio(listAnios);
        Mymodel.setListSemestre(listSemestres);
        
        Mymodel.setSelAnio(request.getParameter("selAnio"));
        Mymodel.setSelSemestre(request.getParameter("selSemestre"));
        
        return new ModelAndView("maestroCursoSemestre","model", Mymodel);
        
    }
    
    
    @RequestMapping(value="maestroCursoSemestreAccion.htm",method= RequestMethod.GET)
    public ModelAndView maestroCursoSemestreAccion(HttpServletRequest request){
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("cursoSemestres", this.cursoSemestresManager.getCursoSemestreAjax(request.getParameter("selAnio"), request.getParameter("selSemestre")));  
        return new ModelAndView("maestroCursoSemestre_Accion","model", myModel);
    }
    
    
    @RequestMapping(value="addCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView addCursoSemestre(HttpServletRequest request, CursoSemestre cursoSemestre){ 

        List listAnios = this.aniosManager.getAnios(); 
        List listSemestres = this.semestresManager.getSemestres();
        List listCursos = this.cursosManager.getCursos();
        List listGrupos = this.gruposManager.getGrupos();
        List listSubGrupos = this.subgruposManager.getSubGrupos();
        List listDocentes = this.docentesManager.getDocentes();

        CursoSemestre cursosemestre = new CursoSemestre();
        cursosemestre.setSelAnio(request.getParameter("selAnio"));
        cursosemestre.setSelSemestre(request.getParameter("selSemestre"));
        cursosemestre.setListAnio(listAnios);
        cursosemestre.setListSemestre(listSemestres);
        cursosemestre.setListCurso(listCursos);
        cursosemestre.setListGrupo(listGrupos);
        cursosemestre.setListSubGrupo(listSubGrupos);
        cursosemestre.setListDocente(listDocentes);
        
        cursosemestre.setTipoAccion("Ingresar los Datos del Curso-Semestre");
        cursosemestre.setBotonAccion("Ingresar");     
        cursosemestre.setAccion("insertarCursoSemestre.htm");   
        
        return new ModelAndView("cursoSemestre","model", cursosemestre);
    }
    
    @RequestMapping(value="insertarCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView insertarCursoSemestre(HttpServletRequest request, CursoSemestre cursoSemestre){ 
        
        CursoSemestre cursoSemestre_form = new CursoSemestre();
        String resultado = cursoSemestresManager.insertCursoSemestre(cursoSemestre); 
        
        if(resultado=="ok"){
            
            String anioS = request.getParameter("id_anio");
            String semS = request.getParameter("id_semestre");
            
            return new ModelAndView("redirect:/maestroCursoSemestre.htm?selAnio="+anioS+"&selSemestre="+semS);
            
        } else{
            
            List listAnios = this.aniosManager.getAnios(); 
            List listSemestres = this.semestresManager.getSemestres();
            List listCursos = this.cursosManager.getCursos();
            List listGrupos = this.gruposManager.getGrupos();
            List listSubGrupos = this.subgruposManager.getSubGrupos();
            List listDocentes = this.docentesManager.getDocentes();

            cursoSemestre_form.setTipoAccion("Ingresar los Datos del Curso-Semestre");
            cursoSemestre_form.setBotonAccion("Ingresar");
            cursoSemestre_form.setAccion("insertarCursoSemestre.htm");
            
            cursoSemestre_form.setSelAnio(request.getParameter("id_anio"));
            cursoSemestre_form.setSelSemestre(request.getParameter("id_semestre"));
            cursoSemestre_form.setSelCurso(request.getParameter("id_curso"));
            cursoSemestre_form.setSelGrupo(request.getParameter("id_grupo"));
            cursoSemestre_form.setSelSubgrupo(request.getParameter("id_subgrupo"));
            cursoSemestre_form.setSelDocente(request.getParameter("id_docente"));
            
            cursoSemestre_form.setListAnio(listAnios);
            cursoSemestre_form.setListSemestre(listSemestres);
            cursoSemestre_form.setListCurso(listCursos);
            cursoSemestre_form.setListGrupo(listGrupos);
            cursoSemestre_form.setListSubGrupo(listSubGrupos);
            cursoSemestre_form.setListDocente(listDocentes);
            
            cursoSemestre_form.setMsgError(resultado);
            
            return new ModelAndView("cursoSemestre","model", cursoSemestre_form);
        }
      
    }
    
    
    
    @RequestMapping(value="editarCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView editarCursoSemestre(HttpServletRequest request){ 
           
        CursoSemestre cursoSemestre = cursoSemestresManager.getCursoSemestre(request.getParameter("id"));
        
        List listAnios = this.aniosManager.getAnios(); 
        List listSemestres = this.semestresManager.getSemestres();
        List listCursos = this.cursosManager.getCursos();
        List listGrupos = this.gruposManager.getGrupos();
        List listSubGrupos = this.subgruposManager.getSubGrupos();
        List listDocentes = this.docentesManager.getDocentes();

         CursoSemestre cursosemestre = new CursoSemestre();
   
         cursosemestre.setSelAnio(cursoSemestre.getId_anio());
         cursosemestre.setSelSemestre(cursoSemestre.getId_semestre());
         cursosemestre.setSelCurso(cursoSemestre.getId_curso());
         cursosemestre.setSelGrupo(cursoSemestre.getId_grupo());
         cursosemestre.setSelSubgrupo(cursoSemestre.getId_subgrupo());
         cursosemestre.setSelDocente(cursoSemestre.getId_docente());
         
         cursosemestre.setListAnio(listAnios);
         cursosemestre.setListSemestre(listSemestres);
         cursosemestre.setListCurso(listCursos);
         cursosemestre.setListGrupo(listGrupos);
         cursosemestre.setListSubGrupo(listSubGrupos);
         cursosemestre.setListDocente(listDocentes);
         
        
        cursosemestre.setTipoAccion("Editar Datos del Curso-Semestre");
        cursosemestre.setBotonAccion("Actualizar");
        cursosemestre.setAccion("editarCursoSemestre.htm");   
        
        return new ModelAndView("cursoSemestre","model", cursosemestre);
    }
    
    
    
    @RequestMapping(value="editarCursoSemestre.htm",method= RequestMethod.POST)
    public ModelAndView editarCursoSemestre(CursoSemestre cursoSemestre, HttpServletRequest request){ 
        
        CursoSemestre cursoSemestre_form = new CursoSemestre();
        String resultado = cursoSemestresManager.updateCursoSemestre(cursoSemestre, request.getParameter("id"));
        
        if(resultado=="ok"){
            
            String anioS = request.getParameter("id_anio");
            String semS = request.getParameter("id_semestre");
            
            return new ModelAndView("redirect:/maestroCursoSemestre.htm?selAnio="+anioS+"&selSemestre="+semS);
            
        } else{
            
            List listAnios = this.aniosManager.getAnios(); 
            List listSemestres = this.semestresManager.getSemestres();
            List listCursos = this.cursosManager.getCursos();
            List listGrupos = this.gruposManager.getGrupos();
            List listSubGrupos = this.subgruposManager.getSubGrupos();
            List listDocentes = this.docentesManager.getDocentes();

            cursoSemestre_form.setTipoAccion("Editar Datos del Curso-Semestre");
            cursoSemestre_form.setBotonAccion("Actualizar");
            cursoSemestre_form.setAccion("editarCursoSemestre.htm");
         
            cursoSemestre_form.setSelAnio(request.getParameter("id_anio"));
            cursoSemestre_form.setSelSemestre(request.getParameter("id_semestre"));
            
            cursoSemestre_form.setSelCurso(request.getParameter("id_curso"));
            cursoSemestre_form.setSelGrupo(request.getParameter("id_grupo"));
            cursoSemestre_form.setSelSubgrupo(request.getParameter("id_subgrupo"));
            cursoSemestre_form.setSelDocente(request.getParameter("id_docente"));
            
            cursoSemestre_form.setListAnio(listAnios);
            cursoSemestre_form.setListSemestre(listSemestres);
            cursoSemestre_form.setListCurso(listCursos);
            cursoSemestre_form.setListGrupo(listGrupos);
            cursoSemestre_form.setListSubGrupo(listSubGrupos);
            cursoSemestre_form.setListDocente(listDocentes);
            
            cursoSemestre_form.setMsgError(resultado);
            
            return new ModelAndView("cursoSemestre","model", cursoSemestre_form);
        }
    }
    
    
    
    
    @RequestMapping(value="eliminarCursoSemestre.htm",method= RequestMethod.GET)
    public ModelAndView eliminarCursoSemestre(HttpServletRequest request){ 

        
        cursoSemestresManager.deleteCursoSemestre(request.getParameter("id"));
        return new ModelAndView("redirect:/maestroCursoSemestre.htm");
    }
    

}
