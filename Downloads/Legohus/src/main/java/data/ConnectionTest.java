
package data;

import java.sql.SQLException;


public class ConnectionTest {

    public static void main(String[] args) {
        ConnectionTest t = new ConnectionTest();
        Connector d = t.getdb();
        System.out.println("Nåede så langt");
    }
    
    public Connector getdb(){
        try {
            Connector db = new Connector();
            return db;
        } catch (Exception ex) {
            System.out.println("Fejl ved forbindelse");
        }
        return null;
    }
}

