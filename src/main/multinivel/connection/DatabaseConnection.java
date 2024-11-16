package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private final String stringConexion = "jdbc:oracle:thin:@localhost:1521:xe";
    private String driver = "oracle.jdbc.driver.OracleDriver";
    private Connection cx;
    private String usr = "system";
    private String passwd = "0426";

    public Connection conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(stringConexion, usr, passwd);
            System.out.println("SE HA LEVANTADO LA CONEXION A LA BASE DE DATOS CORRECTAMENTE");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("NO SE HA LEVANTADO LA CONEXION A LA BASE DE DATOS");
        }
        return cx;
    }
}
