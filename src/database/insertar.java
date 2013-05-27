/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import paquete.Moneda;

/**
 *
 * @author Administrador
 */
public class insertar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

  
  Moneda mon = new Moneda(3,"30 centimos", 2002, 20, 20, 215, "bueno", "cinq", 15, 2, 1, "EStrella 4",1 , 10, "Circulacion", "Ninguna");
  
   Database basedato = new Database();
   basedato.connectDB();
   boolean verdad = basedato.insertTable(mon);
   

        
    }
}
