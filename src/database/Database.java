/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import paquete.Moneda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class Database {

    Connection conn = null;

    //CONECTAR A LA BASE DE DATOS
    public boolean connectDB() {
        String driver = "org.apache.derby.jdbc.ClientDriver()";
        String dbName = "DerbyDB/Coleccionator";
        String dbParam = "create=true"; //la base de datos se creará si no existe todavía
        String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(connectionURL);

        } catch (SQLException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
        System.out.println("se ha conectado");
        return true;
    }

    //CREAR TABLAS    
    public boolean createTable() {
        if (!existsTables()) {

            try {
                Statement st = conn.createStatement();
                String sqlCreateTableMonedas =
                        "CREATE TABLE monedas ( "
                        + "m_id integer not null generated always as identity(start with 1, increment by 1), "
                        + "m_name VARCHAR(30) NOT NULL, "
                        + "m_year INTEGER, "
                        + "m_value DECIMAL(9,2), "
                        + "m_coin INTEGER, "
                        + "m_weight DECIMAL(6,3), "
                        + "m_conservation VARCHAR(30), "
                        + "m_material VARCHAR(20), "
                        + "m_dimx DECIMAL(6,3), "
                        + "m_dimy DECIMAL(6,3), "
                        + "m_category INTEGER, "
                        + "m_variant VARCHAR(30), "
                        + "m_country INTEGER, "
                        + "m_price DECIMAL(9,2), "
                        + "m_type VARCHAR(30), "
                        + "m_observations VARCHAR(200), "
                        + "CONSTRAINT m_id_PK PRIMARY KEY(m_id) "
                        + ")";

                // EJECUTA LA SENTENCIA SQL
                st.execute(sqlCreateTableMonedas);

                // CREAR TABLA CATEGORIAMONEDAS
                String sqlCreateTableCatMonedas =
                        "CREATE TABLE catmonedas ( "
                        + "cm_id integer not null generated always as identity(start with 1, increment by 1), "
                        + "cm_name VARCHAR(30) NOT NULL, "
                        + "CONSTRAINT cm_id_PK PRIMARY KEY (cm_id) "
                        + ")";

                st.execute(sqlCreateTableCatMonedas);

                // CREAR TABLA COUNTRYMONEDAS - PAISES
                String sqlCreateTableCountryMonedas =
                        "CREATE TABLE contrymonedas ( "
                        + "ctm_id integer not null generated always as identity(start with 1, increment by 1), "
                        + "ctm_name VARCHAR(30) NOT NULL, "
                        + "CONSTRAINT ctm_id_PK PRIMARY KEY (ctm_id) "
                        + ")";

                st.execute(sqlCreateTableCountryMonedas);
                
                
                                st.execute(sqlCreateTableCatMonedas);

                // CREAR TABLA VALUEMONEDAS - VALORES
                String sqlCreateTablevalueMonedas =
                        "CREATE TABLE valuemonedas ( "
                        + "vm_id integer not null generated always as identity(start with 1, increment by 1), "
                        + "vm_name VARCHAR(30) NOT NULL, "
                        + "CONSTRAINT vm_id_PK PRIMARY KEY (vm_id) "
                        + ")";

                st.execute(sqlCreateTablevalueMonedas);


                return true;
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            System.out.println("se han creado");
            return true;
        }
    }

    //EXISTEN TABLAS
    public boolean existsTables() {
        try {
            Statement sentenciaSQL = conn.createStatement();
            String textoSQL = "SELECT * FROM monedas ";
            ResultSet resultados = sentenciaSQL.executeQuery(textoSQL);
            resultados.next();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    //INSERTAR DATOS
    public boolean insertTable(Moneda mon) {
        try {
            Statement sentenciaSQL = conn.createStatement();
            sentenciaSQL.executeUpdate("INSERT INTO monedas "
                    + "(m_name, m_year, m_value, m_coin, m_weight, m_conservation, m_material, m_dimx, m_dimy, m_category, m_variant, m_country, m_price, m_type, m_observations) VALUES ("
                    + "'" + mon.getName() + "', "
                    + mon.getYear() + ", "
                    + mon.getValue() + ", "
                    + mon.getCoin() + ", "
                    + mon.getWeight() + ", "
                    + "'" + mon.getConservation() + "', "
                    + "'" + mon.getMaterial() + "', "
                    + mon.getDimx() + ", "
                    + mon.getDimy() + ", "
                    + mon.getCategory() + ", "
                    + "'" + mon.getVariant() + "', "
                    + mon.getCountry() + ", "
                    + mon.getPrice() + ", "
                    + "'" + mon.getType() + "', "
                    + "'" + mon.getObservations() + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //INSERTAR DATOS
    public boolean updateTable(Moneda mon) {
        try {
            Statement sentenciaSQL = conn.createStatement();
            sentenciaSQL.executeUpdate("UPDATE monedas SET "
                    + "m_name = '" + mon.getName() + "', "
                    + "m_year = '" + mon.getYear() + "', "
                    + "m_value = '" + mon.getValue() + "', "
                    + "m_coin = '" + mon.getCoin() + "' "
                    + "m_weight = '" + mon.getWeight() + "', "
                    + "m_conservation = '" + mon.getConservation() + "', "
                    + "m_material = '" + mon.getMaterial() + "', "
                    + "m_dimx = '" + mon.getDimx() + "', "
                    + "m_dimy = '" + mon.getDimy() + "' "
                    + "m_category = '" + mon.getCategory() + "', "
                    + "m_variant = '" + mon.getVariant() + "', "
                    + "m_country = '" + mon.getCountry() + "', "
                    + "m_price = '" + mon.getPrice() + "' "
                    + "m_type = '" + mon.getType() + "' "
                    + "m_observations = '" + mon.getObservations() + "' "
                    + "WHERE m_id = " + mon.getId());

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList selectTable() {
        ArrayList<Moneda> list_m = new ArrayList();
        ResultSet resultados = null;
        
        try {

            Statement sentenciaSQL = conn.createStatement();
            String textoSQL = "SELECT * FROM monedas ";

            resultados = sentenciaSQL.executeQuery(textoSQL);

            while (resultados.next()) {
                int id = resultados.getInt("m_id");
                String name = resultados.getString("m_name");
                int year = resultados.getInt("m_year");
                float value = resultados.getFloat("m_value");
                float coin = resultados.getFloat("m_coin");
                float weight = resultados.getFloat("m_weight");
                String conservation = resultados.getString("m_conservation");
                String material = resultados.getString("m_material");
                float dimx = resultados.getFloat("m_dimx");
                float dimy = resultados.getFloat("m_dimy");
                int category = resultados.getInt("m_category");
                String variant = resultados.getString("m_variant");
                int country = resultados.getInt("m_country");
                float price = resultados.getFloat("m_price");
                String type = resultados.getString("m_type");
                String observations = resultados.getString("m_observations");
                //Crear un objeto Contacto con los datos obtenidos
                Moneda mon = new Moneda(id, name, year, value, coin, weight, conservation, material, dimx, dimy, category, variant, country, price,type, observations);
                //Guardar el contacto en la lista que se retornará
                list_m.add(mon);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_m;

    }

    public Moneda selectMoneda(int idMon) {
        Moneda mon = null;
        ResultSet resultado = null;
        try {
            Statement selectmSQL = conn.createStatement();
            resultado = selectmSQL.executeQuery("SELECT * FROM monedas WHERE m_id = " + idMon);
            if (resultado.next()) {
                int id = resultado.getInt("m_id");
                String name = resultado.getString("m_name");
                int year = resultado.getInt("m_year");
                float value = resultado.getFloat("m_value");
                float coin = resultado.getFloat("m_coin");
                float weight = resultado.getFloat("m_weight");
                String conservation = resultado.getString("m_conservation");
                String material = resultado.getString("m_material");
                float dimx = resultado.getFloat("m_dimx");
                float dimy = resultado.getFloat("m_dimy");
                int category = resultado.getInt("m_category");
                String variant = resultado.getString("m_variant");
                int country = resultado.getInt("m_country");
                float price = resultado.getFloat("m_price");
                String type = resultado.getString("m_type");
                String observations = resultado.getString("m_observations");
                //Crear un objeto Contacto con los datos obtenidos
                mon = new Moneda(id, name, year, value, coin, weight, conservation, material, dimx, dimy, category, variant, country, price, type, observations);
            } else {
                JOptionPane.showMessageDialog(null,
                        "No se ha encontrado el contacto en la base de datos",
                        "Error", JOptionPane.ERROR_MESSAGE);;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mon;

    }
    
    
    
    
}
