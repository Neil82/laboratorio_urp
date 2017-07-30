package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.MarcacionDocente;

public class JdbcMarcacionDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcMarcacionDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<MarcacionDocente> getMarcaciones(String id) {

        List<MarcacionDocente> marcacion =  this.jdbctemplate.query("select id_marcacion, d.coddocente, aula, "
                + "c.descripcion as curso, concat(d.apellidos,' ',d.nombres) as docente, "
                + "s.descripcion as semestre, m.inicio, m.fin, m.tipo, "
                + "m.extemporanea from marcacion m inner join aula a on a.id=m.id_aula "
                + "inner join cursoSemestre cs on cs.id=m.id_cursoSemestre "
                + "inner join curso c on c.id = cs.id_curso "
                + "inner join docente d on d.id=cs.id_docente "
                + "inner join semestre s on s.id=cs.id_semestre "
                + "where d.coddocente = '"+id+"' and m.tipo='I' ", new JdbcMarcacionDao.MarcacionMapper());
        return marcacion;
    } 
    
    public void finalizarMarcacion(String id) {
        
         this.jdbctemplate.update(
            "update marcacion set tipo='E', extemporanea = now() "
                    + "where id_marcacion = ?", 
                 id);
    }
    
    private static class MarcacionMapper implements ParameterizedRowMapper<MarcacionDocente> { 
        public MarcacionDocente mapRow(ResultSet rs, int rowNum) throws SQLException {
            MarcacionDocente marcacion  = new MarcacionDocente();
            marcacion.setId_marcacion(rs.getString("id_marcacion"));
            marcacion.setCod_docente(rs.getString("coddocente"));
            marcacion.setAula(rs.getString("aula"));    
            marcacion.setCurso(rs.getString("curso"));    
            marcacion.setDocente(rs.getString("docente"));    
            marcacion.setSemestre(rs.getString("semestre"));    
            marcacion.setInicio(rs.getString("inicio"));    
            marcacion.setFin(rs.getString("fin"));    
            marcacion.setTipo(rs.getString("tipo"));    
            marcacion.setExtemporanea(rs.getString("extemporanea"));    
            return marcacion;
        } 
    } 
}
