    package database;
     
    //Importamos las siguientes clases necesarias
    import java.sql.Driver;
    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
     
    /** 
     *
     * @Rafa
     */
    public class Conexion {
        
        
 
        
        
        //Establecemos connection para conectarse a la base de datos
        private static Connection connection = null;
        //Utilizamos localhost ya que el servidor correra en nuestra propia maquina
        private static Driver driver = new org.apache.derby.jdbc.ClientDriver();
        private static String URLDerby = "jdbc:derby:DerbyDB/Coleccionator";
        //Establecemos el usuario y la contrasena para conectarnos a la base de datos
        private static String user = "usuario";
        private static String password = "usuario";
       
        public static Connection getConexion() throws SQLException {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URLDerby, user, password);
            return connection;
        }
    }


