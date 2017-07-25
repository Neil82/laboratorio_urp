package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Docente;


public class JdbcDocentesDao  {
    
    private final JdbcTemplate jdbctemplate;
    
    
    public JdbcDocentesDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Docente> getDocentes() {

        List<Docente> docentes = this.jdbctemplate.query("select id, coddocente, nombres, "
                + "apellidos, concat(apellidos,' ',nombres) as docente "
                + "from docente where estado=1 order by apellidos", new JdbcDocentesDao.DocenteMapper());
        return docentes;
    } 
    
     public Docente getDocente(String id) {
        
        List<Docente> docentes =  this.jdbctemplate.query("select id, coddocente, nombres, "
                + "apellidos, concat(apellidos,' ',nombres) as docente "
                + "from docente where id='"+id+"'", new JdbcDocentesDao.DocenteMapper());
        return docentes.get(0);
    }
     
    public List<Docente> getDocenteForm(String id) {

        List<Docente> docentes = this.jdbctemplate.query("select id, coddocente, nombres, apellidos, concat(apellidos,' ',nombres) as docente from docente where id='"+id+"'", new JdbcDocentesDao.DocenteMapper());
        return docentes;
    } 
    
    
    public void insertDocente(Docente docente) {
        
         this.jdbctemplate.update(
            "insert into docente (coddocente, nombres, apellidos, password) values (?,?,?,?)",docente.getCoddocente(), docente.getNombres(), docente.getApellidos(), docente.getPassword());

    }
    
    public void updateDocente(Docente docente, String id) {

        if(docente.getPassword()!=""){
            
            this.jdbctemplate.update(
            "update docente "
                    + "set coddocente = ?, "
                    + "nombres = ?, "
                    + "apellidos = ?, "
                    + "password = ? "
                    + "where "
                    + "id = ?", 
                 docente.getCoddocente(), docente.getNombres(), docente.getApellidos(), docente.getPassword(), id);
        
        } else{
        
            this.jdbctemplate.update(
            "update docente "
                    + "set coddocente = ?, "
                    + "nombres = ?, "
                    + "apellidos = ? "
                    + "where "
                    + "id = ?", 
                 docente.getCoddocente(), docente.getNombres(), docente.getApellidos(), id);
            
        }
    }    
    
    public void deleteDocente(String id) {
        
         this.jdbctemplate.update(
            "update docente "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);

    }
    
    
    public String getDocenteValidacionInsert(String coddocente) {
        
        String name;
        
        try {
            String sql = "select nombres from docente where coddocente = ? and estado=1";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { coddocente }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    public String getDocenteValidacionUpd(String coddocente, String id) {
        
        String name;
        
        try {
            String sql = "select nombres from docente where coddocente = ? and id <> ? and estado=1";
            name = (String)this.jdbctemplate.queryForObject(
                            sql, new Object[] { coddocente, id }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
    
    private static class DocenteMapper implements ParameterizedRowMapper<Docente> { 
        public Docente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Docente docente  = new Docente();
            docente.setId(rs.getString("id"));
            docente.setCoddocente(rs.getString("coddocente"));
            docente.setNombres(rs.getString("nombres")); 
            docente.setApellidos(rs.getString("apellidos")); 
            docente.setDocente_nom(rs.getString("docente")); 
            return docente;
        } 
    } 
}
