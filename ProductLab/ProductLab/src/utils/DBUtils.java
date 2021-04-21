
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBUtils implements Serializable {

    public static Connection openConnection() {
     
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         
            String url = ("jdbc:sqlserver://localhost:1433;databaseName=ProductManagerment;");
            Connection conn = DriverManager.getConnection(url, "sa", "123456");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}
