    package database;
     
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import database.Conexion;
     
    public class conexionconsola {
        static Connection connection = null;
        static Statement statement = null;
        static ResultSet resutSet = null;
     
        public static void main(String[] args) throws SQLException {
                //Obtenemos la conexion a Derby
                connection = Conexion .getConexion();
                String consulta = "SELECT * FROM monedas";
                //Preparamos la consulta
                statement = connection.createStatement();
                //Ejecutamos la consulta
                resutSet = statement.executeQuery(consulta);
     
               
     
                //Recorremos el Resultset
                while (resutSet.next()) {
                    float id,valor, coin, weight, price;
                    String nombre;
     
                    //Recogemos los datos llamando al nombre de la columna
                    //que el Resultset nos devuelve
                    id = resutSet.getInt("m_id");
                    nombre = resutSet.getString("m_name");
                    valor = resutSet.getFloat("m_value");
                    coin = resutSet.getFloat("m_coin");
                    weight = resutSet.getFloat("m_weight");
                    price = resutSet.getFloat("m_price");
                   
                    //Imprimimos datos por consola
                    System.out.println("id \t" + "nombre\t"  + "valor \t" + "coin \t" + "weight \t" +"price" );
                    System.out.println(id + "\t" + nombre + "\t" + valor + "\t" + coin + "\t" + weight+ "\t" +price );
                }
                //Cerramos los elementos que se utilizaron
                resutSet.close();
                resutSet = null;
                statement.close();
                statement= null;
                connection.close();
                connection=null;
        }
    }