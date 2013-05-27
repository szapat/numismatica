/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import paquete.Moneda;

/**
 *
 * @author Administrador
 */
public class consultar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
       ArrayList<Moneda> mon = new ArrayList();
  
   Database basedato = new Database();
   basedato.connectDB();
   mon = basedato.selectTable();
               
   System.out.println(mon.get(0).getId()+mon.get(0).getName()+mon.get(0).getValue());
   System.out.println(mon.get(1).getId()+mon.get(1).getName()+mon.get(1).getValue());
               
    }
}
