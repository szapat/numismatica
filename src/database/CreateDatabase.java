package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class CreateDataBase {

    public static void main(String[] args) {
        String driver = "org.apache.derby.jdbc.ClientDriver()";
        String dbName = "DerbyDB/Coleccionator";
        String dbParam = "create=true"; //la base de datos se creará si no existe todavía
        String connectionURL = "jdbc:derby:" + dbName + ";" + dbParam;
        Connection conn = null;
        try {
            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CreateDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn = DriverManager.getConnection(connectionURL);


            Statement st = conn.createStatement();
            String sqlCreateTableMonedas =
                    "CREATE TABLE monedas ( "
                    + "m_id integer not null generated always as identity(start with 1, increment by 1), "
                    + "m_name VARCHAR(30) NOT NULL, "
                    + "m_year INTEGER, "
                    + "m_value DECIMAL(9,2), "
                    + "m_coin INTEGER, "
                    + "m_weight DECIMAL(6,3), "
                    + "m_material VARCHAR(20), "
                    + "m_dimx DECIMAL(6,3), "
                    + "m_dimy DECIMAL(6,3), "
                    + "m_category INTEGER, "
                    + "m_variant VARCHAR(30), "
                    + "m_country INTEGER, "
                    + "m_price DECIMAL(9,2), "
                    + "m_observations VARCHAR(50), "
                    + "CONSTRAINT m_id_PK PRIMARY KEY(m_id) "
                    + ")";

            // EJECUTA LA SENTENCIA SQL
            st.execute(sqlCreateTableMonedas);

            // CREAR TABLA SELLOS
            String sqlCreateTableSellos =
                    "CREATE TABLE sellos ( "
                    + "s_id integer not null generated always as identity(start with 1, increment by 1), "
                    + "s_name VARCHAR(30) NOT NULL, "
                    + "s_year INTEGER, "
                    + "s_value DECIMAL(9,2), "
                    + "s_coin INTEGER, "
                    + "s_weight DECIMAL(6,3), "
                    + "s_material VARCHAR(20), "
                    + "s_dimx DECIMAL(6,3), "
                    + "s_dimy DECIMAL(6,3), "
                    + "s_category INTEGER, "
                    + "s_country INTEGER, "
                    + "s_price DECIMAL(9,2), "
                    + "s_observations VARCHAR(50), "
                    + "CONSTRAINT s_id_PK PRIMARY KEY (s_id) "
                    + ")";


            // EJECUTA LA SENTENCIA SQL
            st.execute(sqlCreateTableSellos);

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
                    + "CONSTRAINT cm_id_PK PRIMARY KEY (ctm_id) "
                    + ")";

            st.execute(sqlCreateTableCountryMonedas);

            // CREAR TABLA CATEGORIASELLOS
            String sqlCreateTableCatSellos =
                    "CREATE TABLE catsellos ( "
                    + "cs_id integer not null generated always as identity(start with 1, increment by 1), "
                    + "cs_name VARCHAR(30) NOT NULL, "
                    + "CONSTRAINT cs_id_PK PRIMARY KEY (cs_id) "
                    + ")";

            st.execute(sqlCreateTableCatSellos);




            System.out.println("La base de datos '" + dbName + "' se ha creado correctamente");
        } catch (Throwable e) {
            System.out.println("Error al crear la base de datos '" + dbName + "'");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Throwable t) {
            }
        }






    }
}