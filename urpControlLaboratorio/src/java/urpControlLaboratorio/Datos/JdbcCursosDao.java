package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Curso;


public class JdbcCursosDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcCursosDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Curso> getCursos() {

        List<Curso> cursos = this.jdbctemplate.query("select id, codcurso, descripcion from curso where estado=1", new JdbcCursosDao.CursoMapper());
        return cursos;
    } 
    
     public Curso getCurso(String id) {
        
        List<Curso> cursos =  this.jdbctemplate.query("select id, codcurso, descripcion from curso where id='"+id+"'", new JdbcCursosDao.CursoMapper());
        return cursos.get(0);
        
    }
     
    public List<Curso> getCursoForm(String id) {

        List<Curso> cursos = this.jdbctemplate.query("select id, codcurso, descripcion from curso where id='"+id+"'", new JdbcCursosDao.CursoMapper());
        return cursos;
    } 

    
    public void insertCurso(Curso curso) {
        
         this.jdbctemplate.update(
            "insert into curso (codcurso, descripcion) values (?,?)",curso.getCodcurso(), curso.getDescripcion());

    }
    
    public void updateCurso(Curso curso, String id) {
        
         this.jdbctemplate.update(
            "update curso "
                    + "set codcurso = ?, "
                    + "descripcion = ? "
                    + "where "
                    + "id = ?", 
                 curso.getCodcurso(), curso.getDescripcion(), id);

    }    
    
    public void deleteCurso(String id) {
        
         this.jdbctemplate.update(
            "update curso "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);

    }
    
    
    
    
    public String getCursoValidacion(String codcurso) {
        
        String name;
        
        try {
            String sql = "select descripcion from curso where codcurso = ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { codcurso }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    public String getCursoValidacionUpd(String codcurso, String id) {
        
        String name;
        
        try {
            String sql = "select descripcion from curso where codcurso = ? and id <> ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { codcurso, id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    }
    
    
    
    private static class CursoMapper implements ParameterizedRowMapper<Curso> { 
        public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
            Curso curso  = new Curso();
            curso.setId(rs.getString("id"));
            curso.setCodcurso(rs.getString("codcurso"));
            curso.setDescripcion(rs.getString("descripcion"));            
            return curso;
        } 
    } 
}
