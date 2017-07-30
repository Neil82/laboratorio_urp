
package urpControlLaboratorio.Datos;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conexion {
     public DriverManagerDataSource conectar(){ 
        
        DriverManagerDataSource dSource = new DriverManagerDataSource();
        dSource.setDriverClassName("com.mysql.jdbc.Driver");
        dSource.setUrl("jdbc:mysql://localhost:3306/controllaboratorio");
        dSource.setUsername("user_lab");
        dSource.setPassword("5yv9#Tf8");
        return dSource;        
    }

}
