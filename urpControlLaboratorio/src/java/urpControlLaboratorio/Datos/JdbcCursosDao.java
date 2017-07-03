package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Curso;



public class JdbcCursosDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcCursosDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Curso> getCursos() {

        List<Curso> cursos = this.jdbctemplate.query("select id, descripcion from curso where estado=1", new JdbcCursosDao.CursoMapper());
        return cursos;
    } 
    
     public Curso getCurso(String id) {
        
        List<Curso> cursos =  this.jdbctemplate.query("select id, descripcion from curso where id='"+id+"'", new JdbcCursosDao.CursoMapper());
        return cursos.get(0);
        
    }
     
    public List<Curso> getCursoForm(String id) {

        List<Curso> cursos = this.jdbctemplate.query("select id, descripcion from curso where id='"+id+"'", new JdbcCursosDao.CursoMapper());
        return cursos;
    } 
    
    public String getCursoValidacion(String id) {
        
        String name;
        
        try {
            String sql = "select descripcion from curso where id = ?";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertCurso(Curso curso) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into curso (id, descripcion) values (?,?)",curso.getId(), curso.getDescripcion());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateCurso(Curso curso, String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update curso "
                    + "set descripcion = ? "
                    + "where "
                    + "id = ?", 
                 curso.getDescripcion(), id);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteCurso(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update curso "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class CursoMapper implements ParameterizedRowMapper<Curso> { 
        public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
            Curso curso  = new Curso();
            curso.setId(rs.getString("id"));
            curso.setDescripcion(rs.getString("descripcion"));            
            return curso;
        } 
    } 
}
