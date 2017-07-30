package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.CursoSemestre;


public class JdbcCursoSemestresDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcCursoSemestresDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<CursoSemestre> getCursoSemestres() {

        List<CursoSemestre> cursoSemestres = 
                this.jdbctemplate.query("select cs.id, a.anio, s.descripcion as semestre, "
                + "c.descripcion as curso, g.descripcion as grupo, sg.descripcion as subgrupo, "
                + "concat(d.apellidos,' ',d.nombres) as docente "
                + "from cursoSemestre cs left join anio a on a.id=cs.id_anio "
                + "left join semestre s on s.id=cs.id_semestre "
                + "left join curso c on c.id=cs.id_curso "
                + "left join grupo g on g.id=cs.id_grupo "
                + "left join subgrupo sg on sg.id=cs.id_subgrupo "
                + "left join docente d on d.id=cs.id_docente "
                + "where cs.estado=1", 
                        new JdbcCursoSemestresDao.CursoSemestreMapper());
        return cursoSemestres;
    } 
    
    public List<CursoSemestre> getCursoSemestreForm(String id_anio, String id_semestre) {

        List<CursoSemestre> cursoSemestres = 
                this.jdbctemplate.query("select cs.id, "
                + "concat(c.descripcion,' - ',d.apellidos,' ',d.nombres) as cursoDocente "
                + "from cursoSemestre cs left join anio a on a.id=cs.id_anio "
                + "left join curso c on c.id=cs.id_curso "
                + "left join docente d on d.id=cs.id_docente "
                + "where cs.id_anio='"+id_anio+"' and cs.id_semestre='"+id_semestre+"'", new JdbcCursoSemestresDao.CursoSemestreFormMapper());
        return cursoSemestres;
    }
    
    
    public List<CursoSemestre> getCursoSemestreAjax(String id_anio, String id_semestre) {

        List<CursoSemestre> cursoSemestres = 
                this.jdbctemplate.query("select cs.id, a.id as id_anio, a.anio, "
                + "s.id as id_semestre, s.descripcion as semestre,"
                + "c.descripcion as curso, g.descripcion as grupo, sg.descripcion as subgrupo,"
                + "concat(d.apellidos,' ',d.nombres) as docente "
                + "from cursoSemestre cs left join anio a on a.id=cs.id_anio "
                + "left join semestre s on s.id=cs.id_semestre "
                + "left join curso c on c.id=cs.id_curso "
                + "left join grupo g on g.id=cs.id_grupo "
                + "left join subgrupo sg on sg.id=cs.id_subgrupo "
                + "left join docente d on d.id=id_docente "
                + "where cs.id_anio='"+id_anio+"' and cs.id_semestre='"+id_semestre+"'", new JdbcCursoSemestresDao.CursoSemestreAjaxMapper());
        return cursoSemestres;
    } 
    
    
    public CursoSemestre getCursoSemestre(String id) {
        
        List<CursoSemestre> cursoSemestres =  this.jdbctemplate.query("select cs.id, a.anio, "
                + "s.id as semestre,"
                + "c.id as curso, g.id as grupo, sg.id as subgrupo,"
                + "d.id as docente "
                + "from cursoSemestre cs left join anio a on a.id=cs.id_anio "
                + "left join semestre s on s.id=cs.id_semestre "
                + "left join curso c on c.id=cs.id_curso "
                + "left join grupo g on g.id=cs.id_grupo "
                + "left join subgrupo sg on sg.id=cs.id_subgrupo "
                + "left join docente d on d.id=id_docente "
                + "where cs.id='"+id+"'", new JdbcCursoSemestresDao.CursoSemestreMapper());
        return cursoSemestres.get(0);
        
    }
    
    public String getCursoSemestreValidacionInsert(String id_anio, String id_semestre, String id_curso, String id_grupo, String id_subgrupo) {
        
        String name;
        
        try {
            String sql = "select id_anio from cursoSemestre where id_anio = ? "
                    + " and id_semestre = ? and id_curso = ? and id_grupo = ? and id_subgrupo = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_curso, id_grupo, id_subgrupo }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    public String getCursoSemestreValidacionUpd(String id_anio, String id_semestre, String id_curso, String id_grupo, String id_subgrupo, String id_docente, String id) {
        
        String name;
        
        try {
            String sql = "select id_anio from cursoSemestre where id_anio = ? "
                    + " and id_semestre = ? and id_curso = ? and id_grupo = ? and id_subgrupo = ? and id_docente = ? and id <> ? and estado=1";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_curso, id_grupo, id_subgrupo, id_docente, id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertCursoSemestre(CursoSemestre cursoSemestre) {
        
         this.jdbctemplate.update(
            "insert into cursoSemestre (id_anio, id_semestre, id_curso, id_grupo, id_subgrupo, "
                    + "id_docente) values (?,?,?,?,?,?)",
                 cursoSemestre.getId_anio(), cursoSemestre.getId_semestre(), cursoSemestre.getId_curso(), 
                 cursoSemestre.getId_grupo(), cursoSemestre.getId_subgrupo(), cursoSemestre.getId_docente());
        
    }
    
    public void updateCursoSemestre(CursoSemestre cursoSemestre, String id) {
        
         this.jdbctemplate.update(
            "update cursoSemestre "
                    + "set id_anio = ?, "
                    + "id_semestre = ?, "
                    + "id_curso = ?, "
                    + "id_grupo = ?, "
                    + "id_subgrupo = ?, "
                    + "id_docente = ? "
                    + "where id = ?", 
                 cursoSemestre.getId_anio(), cursoSemestre.getId_semestre(), 
                 cursoSemestre.getId_curso(), cursoSemestre.getId_grupo(), 
                 cursoSemestre.getId_subgrupo(), cursoSemestre.getId_docente(), id);
        
    }    
    
    public void deleteCursoSemestre(String id) {
        
         this.jdbctemplate.update(
            "update cursoSemestre "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);

    }
    
    private static class CursoSemestreMapper implements ParameterizedRowMapper<CursoSemestre> { 
        public CursoSemestre mapRow(ResultSet rs, int rowNum) throws SQLException {
            CursoSemestre cursoSemestre  = new CursoSemestre();
            cursoSemestre.setId(rs.getString("id"));
            cursoSemestre.setId_anio(rs.getString("anio"));
            cursoSemestre.setId_semestre(rs.getString("semestre"));
            cursoSemestre.setId_curso(rs.getString("curso"));
            cursoSemestre.setId_grupo(rs.getString("grupo"));
            cursoSemestre.setId_subgrupo(rs.getString("subgrupo"));
            cursoSemestre.setId_docente(rs.getString("docente"));
            return cursoSemestre;
        } 
    }
    
    private static class CursoSemestreAjaxMapper implements ParameterizedRowMapper<CursoSemestre> { 
        public CursoSemestre mapRow(ResultSet rs, int rowNum) throws SQLException {
            CursoSemestre cursoSemestre  = new CursoSemestre();
            cursoSemestre.setId(rs.getString("id"));
            cursoSemestre.setSelAnio(rs.getString("id_anio"));
            cursoSemestre.setSelSemestre(rs.getString("id_semestre"));
            cursoSemestre.setId_anio(rs.getString("anio"));
            cursoSemestre.setId_semestre(rs.getString("semestre"));
            cursoSemestre.setId_curso(rs.getString("curso"));
            cursoSemestre.setId_grupo(rs.getString("grupo"));
            cursoSemestre.setId_subgrupo(rs.getString("subgrupo"));
            cursoSemestre.setId_docente(rs.getString("docente"));
            return cursoSemestre;
        } 
    }
    
    private static class CursoSemestreFormMapper implements ParameterizedRowMapper<CursoSemestre> { 
        public CursoSemestre mapRow(ResultSet rs, int rowNum) throws SQLException {
            CursoSemestre cursoSemestre  = new CursoSemestre();
            cursoSemestre.setId(rs.getString("id"));
            cursoSemestre.setCursoDocente(rs.getString("cursoDocente"));
            return cursoSemestre;
        } 
    } 
}
