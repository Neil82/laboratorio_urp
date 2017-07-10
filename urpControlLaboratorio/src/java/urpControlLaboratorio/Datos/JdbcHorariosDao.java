package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import urpControlLaboratorio.Entidades.Horario;



public class JdbcHorariosDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcHorariosDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    
    public List<Horario> getHorarios() {

        List<Horario> horarios = 
        this.jdbctemplate.query("select h.id, a.id as anio, s.descripcion as semestre, "
                + "au.id as aula, d.descripcion as dia, hi.descripcion as hora_inicio, "
                + "hf.descripcion as duracion, concat(c.descripcion,' - ',do.apellidos,' ',do.nombres) as cursosemestre "
                + "from horario h left join anio a on a.id = h.id_anio "
                + "left join semestre s on s.id = h.id_semestre "
                + "left join aula au on au.id = h.id_aula "
                + "left join dia d on d.id = h.id_dia "
                + "left join hora hi on hi.id = h.id_hinicio "
                + "left join duracion hf on hf.id = h.id_duracion "
                + "left join cursoSemestre cs on cs.id = h.id_cursosemestre "
                + "left join curso c on c.id = cs.id_curso "
                + "left join docente do on do.id = cs.id_docente "
                + "where h.estado=1", new JdbcHorariosDao.HorarioMapper());
        return horarios;
    } 
    
     public Horario getHorario(String id) {
        
        List<Horario> horarios =  this.jdbctemplate.query("select h.id, a.id as anio, s.id as semestre, "
                + "au.id as aula, d.id as dia, hi.id as hora_inicio, "
                + "hf.id as duracion, concat(c.descripcion,' - ',do.apellidos,' ',do.nombres) as cursosemestre "
                + "from horario h left join anio a on a.id = h.id_anio "
                + "left join semestre s on s.id = h.id_semestre "
                + "left join aula au on au.id = h.id_aula "
                + "left join dia d on d.id = h.id_dia "
                + "left join hora hi on hi.id = h.id_hinicio "
                + "left join duracion hf on hf.id = h.id_duracion "
                + "left join cursoSemestre cs on cs.id = h.id_cursosemestre "
                + "left join curso c on c.id = cs.id_curso "
                + "left join docente do on do.id = cs.id_docente "
                + "where h.id='"+id+"'", new JdbcHorariosDao.HorarioMapper());
        return horarios.get(0);
        
    }
     
    public List<Horario> getHorarioAjax(String id_anio, String id_semestre, String id_aula) {
        
        List<Horario> horarios =  this.jdbctemplate.query("select h.id, a.id as anio, s.descripcion as semestre, "
                + "au.id as aula, d.descripcion as dia, hi.descripcion as hora_inicio, "
                + "hf.descripcion as duracion, concat(c.descripcion,' - ',do.apellidos,' ',do.nombres) as cursosemestre "
                + "from horario h left join anio a on a.id = h.id_anio "
                + "left join semestre s on s.id = h.id_semestre "
                + "left join aula au on au.id = h.id_aula "
                + "left join dia d on d.id = h.id_dia "
                + "left join hora hi on hi.id = h.id_hinicio "
                + "left join duracion hf on hf.id = h.id_duracion "
                + "left join cursoSemestre cs on cs.id = h.id_cursosemestre "
                + "left join curso c on c.id = cs.id_curso "
                + "left join docente do on do.id = cs.id_docente "
                + "where h.id_anio='"+id_anio+"' and h.id_semestre='"+id_semestre+"' and "
                + "id_aula ='"+id_aula+"'", new JdbcHorariosDao.HorarioMapper());
        return horarios;
        
    } 
    
    public String getHorarioValidacion(String id_anio, String id_semestre, String id_aula, 
            String id_dia, String id_hinicio, String id_duracion, String id_cursosemestre) {
        
        String name;
        
        try {
            String sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and "
                    + " id_duracion = ? and id_cursosemestre = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicio, id_duracion, id_cursosemestre }, String.class);
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
    } 
     
    public void insertHorario(Horario horario) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into horario (id_anio, id_semestre, id_aula, id_dia, id_hinicio, "
                    + " id_duracion, id_cursosemestre) values (?,?,?,?,?,?,?)",
                 horario.getId_anio(), horario.getId_semestre(), horario.getId_aula(), horario.getId_dia(), 
                 horario.getId_hinicio(), horario.getId_duracion(), horario.getId_cursosemestre());
        
        //logger.info("Rows affected: " + count);
    }
    
    public void updateHorario(Horario horario, String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update horario "
                    + "set id_anio = ?, "
                    + "set id_semestre = ?, "
                    + "set id_aula = ?, "
                    + "set id_dia = ?, "
                    + "set id_hinicio = ?, "
                    + "set id_duracion = ?, "
                    + "set id_cursosemestre = ? "
                    + "where "
                    + "id = ?", 
                 horario.getId_anio(), horario.getId_semestre(), horario.getId_aula(), horario.getId_dia(), 
                 horario.getId_hinicio(), horario.getId_duracion(), horario.getId_cursosemestre(), id);
        
        //logger.info("Rows affected: " + count);
    }    
    
    public void deleteHorario(String id) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "update horario "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
        //logger.info("Rows affected: " + count);
    }
    
    private static class HorarioMapper implements ParameterizedRowMapper<Horario> { 
        public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Horario horario  = new Horario();
            horario.setId(rs.getString("id"));
            horario.setId_anio(rs.getString("anio")); 
            horario.setId_semestre(rs.getString("semestre"));
            horario.setId_aula(rs.getString("aula"));
            horario.setId_dia(rs.getString("dia"));
            horario.setId_hinicio(rs.getString("hora_inicio"));
            horario.setId_duracion(rs.getString("duracion"));
            horario.setId_cursosemestre(rs.getString("cursosemestre"));
            return horario;
        } 
    } 
}
