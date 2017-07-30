package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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
                + "au.id as aula, d.descripcion as dia, hi.descripcion as hora_inicio, hi.hora_fin, "
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
                + "au.id as aula, d.id as dia, hi.id as hora_inicio, hi.hora_fin, "
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
        
        List<Horario> horarios =  this.jdbctemplate.query("call sp_horario ('"+id_aula+"', '"+id_anio+"', '"+id_semestre+"')", new JdbcHorariosDao.HorarioReporteMapper());
        return horarios;
        
    }
    
     
    public void insertHorario(Horario horario) {
        
         this.jdbctemplate.update(
            "insert into horario (id_anio, id_semestre, id_aula, id_dia, id_hinicio, "
                    + " id_duracion, id_cursosemestre) values (?,?,?,?,?,?,?)",
                 horario.getId_anio(), horario.getId_semestre(), horario.getId_aula(), horario.getId_dia(), 
                 horario.getId_hinicio(), horario.getId_duracion(), horario.getId_cursosemestre());
        
    }
    
    public void updateHorario(Horario horario, String id) {
        
         this.jdbctemplate.update(
            "update horario "
                    + "set id_anio = ?, "
                    + " id_semestre = ?, "
                    + " id_aula = ?, "
                    + " id_dia = ?, "
                    + " id_hinicio = ?, "
                    + " id_duracion = ?, "
                    + " id_cursosemestre = ? "
                    + "where "
                    + "id = ?", 
                 horario.getId_anio(), horario.getId_semestre(), horario.getId_aula(), horario.getId_dia(), 
                 horario.getId_hinicio(), horario.getId_duracion(), horario.getId_cursosemestre(), id);

    }    
    
    public void deleteHorario(String id) {
        
         this.jdbctemplate.update(
            "update horario "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
       
    }
    
    
    public String getHorarioValidacionInsert(String id_anio, String id_semestre, String id_aula, 
            String id_dia, String id_hinicio, String id_duracion, String id_cursosemestre) {
        
        String name = "";
        Integer cantidad = 0;
        Integer durac_test = 0;
        Integer id_duracionT = Integer.parseInt(id_duracion);
        Integer id_hinicioT = Integer.parseInt(id_hinicio);
        Integer id_hinicioTT = Integer.parseInt(id_hinicio);
        
        try {
            
            String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? ";
            cantidad = (Integer)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicio }, Integer.class);
        
            } catch (final EmptyResultDataAccessException e) { name = ""; cantidad=0; }
        
        
        
            if(cantidad <= 0 && id_hinicioT > 1){
            
                try {
                    id_hinicioT = id_hinicioT - 1;

                    String sql = "select id_duracion from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    durac_test = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT }, Integer.class);
                    if(durac_test >= 2){ name="repetido"; }
                    
                } catch (final EmptyResultDataAccessException e) { cantidad = 0; durac_test=0; }
                
                
                try {
                    if(durac_test <= 0 && id_hinicioT > 1){
                        id_hinicioT = id_hinicioT - 1;

                        String sql = "select id_duracion from horario where id_anio = ? "
                                + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                        durac_test = (Integer)this.jdbctemplate.queryForObject(
                                sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT }, Integer.class);
                    }
                    if(durac_test >= 3){ name="repetido"; }
                } catch (final EmptyResultDataAccessException e) { cantidad = 0; durac_test=0;  }
                
                
                try {
                    if(durac_test <= 0 && id_hinicioT > 1){
                        id_hinicioT = id_hinicioT - 1;

                        String sql = "select id_duracion from horario where id_anio = ? "
                                + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                        durac_test = (Integer)this.jdbctemplate.queryForObject(
                                sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT }, Integer.class);
                    }
                    if(durac_test >= 4){ name="repetido"; }
                } catch (final EmptyResultDataAccessException e) { cantidad = 0; durac_test=0;  }
                
                
                try {
                    if(durac_test <= 0 && id_hinicioT > 1){
                        id_hinicioT = id_hinicioT - 1;

                        String sql = "select id_duracion from horario where id_anio = ? "
                                + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                        durac_test = (Integer)this.jdbctemplate.queryForObject(
                                sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT }, Integer.class);
                    }
                    if(durac_test >= 5){ name="repetido"; }
                } catch (final EmptyResultDataAccessException e) { cantidad = 0; durac_test=0;  }
                
                
                try {
                    if(durac_test <= 0 && id_hinicioT > 1){
                        id_hinicioT = id_hinicioT - 1;

                        String sql = "select id_duracion from horario where id_anio = ? "
                                + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                        durac_test = (Integer)this.jdbctemplate.queryForObject(
                                sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT }, Integer.class);
                    }
                    if(durac_test >= 6){ name="repetido"; }
                } catch (final EmptyResultDataAccessException e) { cantidad = 0; durac_test=0;  }
                
                
                try {
                    if(durac_test <= 0 && id_hinicioT > 1){
                        id_hinicioT = id_hinicioT - 1;

                        String sql = "select id_duracion from horario where id_anio = ? "
                                + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                        durac_test = (Integer)this.jdbctemplate.queryForObject(
                                sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT }, Integer.class);
                    }
                    if(durac_test >= 7){ name="repetido"; }
                } catch (final EmptyResultDataAccessException e) { cantidad = 0; durac_test=0;  }
                
            }
            
            if(cantidad > 0){
                name="repetido";
            }
            
            
            try {
                if(name.equals("") && id_duracionT >= 2){
                    id_hinicioTT = id_hinicioTT + 1;

                    String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    cantidad = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioTT }, Integer.class);
                    if(cantidad > 0){ name="repetido"; }
                }
            } catch (final EmptyResultDataAccessException e) { cantidad = 0; name="";}
            
            try {
                if(name.equals("") && id_duracionT >= 3){
                    id_hinicioTT = id_hinicioTT + 1;

                    String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    cantidad = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioTT }, Integer.class);
                    if(cantidad > 0){ name="repetido"; }
                }
            } catch (final EmptyResultDataAccessException e) { cantidad = 0; name=""; }
            
            try {
                if(name.equals("") && id_duracionT >= 4){
                    id_hinicioTT = id_hinicioTT + 1;

                    String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    cantidad = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioTT }, Integer.class);
                    if(cantidad > 0){ name="repetido"; }
                }
            } catch (final EmptyResultDataAccessException e) { cantidad = 0; name=""; }
            
            try {
                if(name.equals("") && id_duracionT >= 5){
                    id_hinicioTT = id_hinicioTT + 1;

                    String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    cantidad = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioTT }, Integer.class);
                    if(cantidad > 0){ name="repetido"; }
                }
            } catch (final EmptyResultDataAccessException e) { cantidad = 0; name=""; }
            
            try {
                if(name.equals("") && id_duracionT >= 6){
                    id_hinicioTT = id_hinicioTT + 1;

                    String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    cantidad = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioTT }, Integer.class);
                    if(cantidad > 0){ name="repetido"; }
                }
            } catch (final EmptyResultDataAccessException e) { cantidad = 0; name=""; }
            
            try {
                if(name.equals("") && id_duracionT >= 7){
                    id_hinicioTT = id_hinicioTT + 1;

                    String sql = "select count(id_anio) as cantidad from horario where id_anio = ? "
                            + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ?";
                    cantidad = (Integer)this.jdbctemplate.queryForObject(
                            sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioTT }, Integer.class);
                    if(cantidad > 0){ name="repetido"; }
                }
            } catch (final EmptyResultDataAccessException e) { cantidad = 0; name=""; }
            
            if(name.equals("")){ name = null; }
            
        
         
	return name;
    } 
    
    public String getHorarioValidacionUpd(String id_anio, String id_semestre, String id_aula, 
            String id_dia, String id_hinicio, String id_duracion, String id_cursosemestre, String id) {
        
        String name;
        int id_duracionT = Integer.parseInt(id_duracion);
        
        try {
            String sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicio, id }, String.class);
            
            if(id_duracionT >= 2){
                
                int id_hinicioT = Integer.parseInt(id_hinicio);
                id_hinicioT = id_hinicioT + 1;
                        
                sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
                name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT, id }, String.class);
            }
            
            if(id_duracionT >= 3){
                
                int id_hinicioT = Integer.parseInt(id_hinicio);
                id_hinicioT = id_hinicioT + 2;
                        
                sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
                name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT, id }, String.class);
            }
            
            if(id_duracionT >= 4){
                
                int id_hinicioT = Integer.parseInt(id_hinicio);
                id_hinicioT = id_hinicioT + 3;
                        
                sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
                name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT, id }, String.class);
            }
            
            if(id_duracionT >= 5){
                
                int id_hinicioT = Integer.parseInt(id_hinicio);
                id_hinicioT = id_hinicioT + 4;
                        
                sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
                name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT, id }, String.class);
            }
            
            if(id_duracionT >= 6){
                
                int id_hinicioT = Integer.parseInt(id_hinicio);
                id_hinicioT = id_hinicioT + 5;
                        
                sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
                name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT, id }, String.class);
            }
            
            if(id_duracionT >= 7){
                
                int id_hinicioT = Integer.parseInt(id_hinicio);
                id_hinicioT = id_hinicioT + 6;
                        
                sql = "select id_anio from horario where id_anio = ? "
                    + " and id_semestre = ? and id_aula = ? and id_dia = ? and id_hinicio = ? and id <> ?";
                name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { id_anio, id_semestre, id_aula, id_dia, id_hinicioT, id }, String.class);
            }
            
        } catch (final EmptyResultDataAccessException e) {
	  name = null;
        
         }
         
	return name;
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
            horario.setHora_fin(rs.getString("hora_fin"));
            horario.setId_duracion(rs.getString("duracion"));
            horario.setId_cursosemestre(rs.getString("cursosemestre"));
            return horario;
        } 
    } 
    
    private static class HorarioReporteMapper implements ParameterizedRowMapper<Horario> { 
        public Horario mapRow(ResultSet rs, int rowNum) throws SQLException {
            Horario horario = new Horario();
            horario.setRep_horaInicio(rs.getString("hora_inicio"));
            horario.setRep_horaFin(rs.getString("hora_fin"));
            
            horario.setRep_lunes(rs.getString("lunes"));
            horario.setRep_martes(rs.getString("martes"));
            horario.setRep_miercoles(rs.getString("miercoles"));
            horario.setRep_jueves(rs.getString("jueves"));
            horario.setRep_viernes(rs.getString("viernes"));
            horario.setRep_sabado(rs.getString("sabado"));
            
            horario.setRep_lunes_dur(rs.getString("lunes_dur"));
            horario.setRep_martes_dur(rs.getString("martes_dur"));
            horario.setRep_miercoles_dur(rs.getString("miercoles_dur"));
            horario.setRep_jueves_dur(rs.getString("jueves_dur"));
            horario.setRep_viernes_dur(rs.getString("viernes_dur"));
            horario.setRep_sabado_dur(rs.getString("sabado_dur"));
            
            horario.setRep_lunes_docente(rs.getString("lunes_profe"));
            horario.setRep_martes_docente(rs.getString("martes_profe"));
            horario.setRep_miercoles_docente(rs.getString("miercoles_profe"));
            horario.setRep_jueves_docente(rs.getString("jueves_profe"));
            horario.setRep_viernes_docente(rs.getString("viernes_profe"));
            horario.setRep_sabado_docente(rs.getString("sabado_profe"));
            
            horario.setRep_lunes_grupo(rs.getString("lunes_grupo"));
            horario.setRep_martes_grupo(rs.getString("martes_grupo"));
            horario.setRep_miercoles_grupo(rs.getString("miercoles_grupo"));
            horario.setRep_jueves_grupo(rs.getString("jueves_grupo"));
            horario.setRep_viernes_grupo(rs.getString("viernes_grupo"));
            horario.setRep_sabado_grupo(rs.getString("sabado_grupo"));
            
            return horario;
        } 
    } 
}
