package urpControlLaboratorio.Datos; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List; 
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import urpControlLaboratorio.Entidades.Equipo;

public class JdbcEquiposDao  {
    
    private JdbcTemplate jdbctemplate;
    
    public JdbcEquiposDao(){
        Conexion con = new Conexion();
        this.jdbctemplate = new JdbcTemplate(con.conectar());
    }
    
    public List<Equipo> getEquipos() {

        List<Equipo> equipos = this.jdbctemplate.query("select distinct e.id, e.eqnombre, e.cpu_marca, "
                + "e.cpu_modelo, e.cpu_serie, e.procesador, e.velocidad, "
                + "e.ram, e.disco_d, e.tvideo, a.aula as idaula, "
                + "e.monitor_marca, e.monitor_modelo, e.monitor_serie, e.teclado_marca, "
                + "e.teclado_modelo, e.teclado_serie, e.mouse_marca, e.mouse_modelo, "
                + "e.mouse_serie from equipo e left join aula a on e.idaula=a.id where e.estado = 1", new JdbcEquiposDao.EquipoMapper());
        return equipos;
    } 
    
     public Equipo getEquipo(String id) {
        
        List<Equipo> equipos =  this.jdbctemplate.query("select distinct e.id, e.eqnombre, e.cpu_marca, "
                + "e.cpu_modelo, e.cpu_serie, e.procesador, e.velocidad, "
                + "e.ram, e.disco_d, e.tvideo, a.id as idaula, "
                + "e.monitor_marca, e.monitor_modelo, e.monitor_serie, e.teclado_marca, "
                + "e.teclado_modelo, e.teclado_serie, e.mouse_marca, e.mouse_modelo, "
                + "e.mouse_serie from equipo e left join aula a on e.idaula=a.id where e.id='"+id+"'", new JdbcEquiposDao.EquipoMapper());
        return equipos.get(0);
        
    }
     
    public void insertEquipo(Equipo equipo) {
        //logger.info("Saving product: " + prod.getDescription());
        
         this.jdbctemplate.update(
            "insert into equipo (eqnombre, cpu_marca, cpu_modelo, cpu_serie, procesador, "
                    + "velocidad, ram, disco_d, tvideo, "
                    + "idaula, monitor_marca, monitor_modelo, monitor_serie, teclado_marca, "
                    + "teclado_modelo, teclado_serie, mouse_marca, mouse_modelo, mouse_serie) "
                    + "values (?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?)",
                 equipo.getEqnombre(),
                 equipo.getCpu_marca(),
                 equipo.getCpu_modelo(),
                 equipo.getCpu_serie(),
                 equipo.getProcesador(),
                 equipo.getVelocidad(),
                 equipo.getRam(),
                 equipo.getDisco_d(),
                 equipo.getTvideo(),
                 equipo.getIdaula(),
                 
                 equipo.getMonitor_marca(),
                 equipo.getMonitor_modelo(),
                 equipo.getMonitor_serie(),
                 equipo.getTeclado_marca(),
                 equipo.getTeclado_modelo(),
                 equipo.getTeclado_serie(),
                 equipo.getMouse_marca(),
                 equipo.getMouse_modelo(),
                 equipo.getMouse_serie()
         );
        
    }
    
    public void updateEquipo(Equipo equipo, String id) {
        
         this.jdbctemplate.update(
            "update equipo "
                    + "set eqnombre = ?, "
                    + " cpu_marca = ?, "
                    + " cpu_modelo = ?, "
                    + " cpu_serie = ?, "
                    + " procesador = ?, "
                    + " velocidad = ?, "
                    + " ram = ?, "
                    + " disco_d = ?, "
                    + " tvideo = ?, "
                    + " idaula = ?, "
                    
                    + " monitor_marca = ?, "
                    + " monitor_modelo = ?, "
                    + " monitor_serie = ?, "
                    + " teclado_marca = ?, "
                    + " teclado_modelo = ?, "
                    + " teclado_serie = ?, "
                    + " mouse_marca = ?, "
                    + " mouse_modelo = ?, "
                    + " mouse_serie = ? "
                    
                    + "where "
                    + "id = ?", 
                 equipo.getEqnombre(),
                 equipo.getCpu_marca(),
                 equipo.getCpu_modelo(),
                 equipo.getCpu_serie(),
                 equipo.getProcesador(),
                 equipo.getVelocidad(),
                 equipo.getRam(),
                 equipo.getDisco_d(),
                 equipo.getTvideo(),
                 equipo.getIdaula(),
                 
                 equipo.getMonitor_marca(),
                 equipo.getMonitor_modelo(),
                 equipo.getMonitor_serie(),
                 equipo.getTeclado_marca(),
                 equipo.getTeclado_modelo(),
                 equipo.getTeclado_serie(),
                 equipo.getMouse_marca(),
                 equipo.getMouse_modelo(),
                 equipo.getMouse_serie(),
                 id
         );
       
    }    
    
    public void deleteEquipo(String id) {
        
         this.jdbctemplate.update(
            "update equipo "
                    + "set estado = 0 "
                    + "where "
                    + "id = ?", 
                 id);
        
    }
    
    
    public String getEquipoValidacionInsert(String eqnombre, String cpu_marca, String cpu_modelo, 
                String cpu_serie, String procesador, String velocidad, 
                String ram, String disco_d, String tvideo, String idaula) {
        
        String name;
        
        try {
            String sql = "select eqnombre from equipo where eqnombre = ? and cpu_marca = ? and "
                    + "cpu_modelo = ? and cpu_serie = ? and procesador = ? and "
                    + "velocidad = ? and ram = ? and disco_d = ? and tvideo = ? and idaula = ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { eqnombre, cpu_marca, cpu_modelo, cpu_serie, procesador, velocidad, ram, disco_d, tvideo, idaula }, String.class);
            } catch (final EmptyResultDataAccessException e) {
            name = null;
        
            }
         
	return name;
    } 
    
    public String getEquipoValidacionUpd(String eqnombre, String id) {
        
        String name;
        
        try {
            String sql = "select eqnombre from equipo where eqnombre = ? and id <> ?";
            name = (String)this.jdbctemplate.queryForObject(
			sql, new Object[] { eqnombre, id }, String.class);
            } catch (final EmptyResultDataAccessException e) {
            name = null;
        
            }
         
	return name;
    } 
    
    
    private static class EquipoMapper implements ParameterizedRowMapper<Equipo> { 
        public Equipo mapRow(ResultSet rs, int rowNum) throws SQLException {
            Equipo equipo  = new Equipo();
            equipo.setId(rs.getString("id"));
            equipo.setEqnombre(rs.getString("eqnombre"));
            equipo.setCpu_marca(rs.getString("cpu_marca"));
            equipo.setCpu_modelo(rs.getString("cpu_modelo"));
            equipo.setCpu_serie(rs.getString("cpu_serie"));
            equipo.setProcesador(rs.getString("procesador"));      
            equipo.setVelocidad(rs.getString("velocidad"));      
            equipo.setRam(rs.getString("ram"));      
            equipo.setDisco_d(rs.getString("disco_d"));      
            equipo.setTvideo(rs.getString("tvideo"));      
            equipo.setIdaula(rs.getString("idaula"));      
            
            equipo.setMonitor_marca(rs.getString("monitor_marca"));      
            equipo.setMonitor_modelo(rs.getString("monitor_modelo"));      
            equipo.setMonitor_serie(rs.getString("monitor_serie"));      
            equipo.setTeclado_marca(rs.getString("teclado_marca"));      
            equipo.setTeclado_modelo(rs.getString("teclado_modelo"));      
            equipo.setTeclado_serie(rs.getString("teclado_serie"));      
            equipo.setMouse_marca(rs.getString("mouse_marca"));      
            equipo.setMouse_modelo(rs.getString("mouse_modelo"));      
            equipo.setMouse_serie(rs.getString("mouse_serie"));      
            return equipo;
        } 
    } 
}