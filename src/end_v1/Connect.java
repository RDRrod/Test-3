package end_v1;

import java.sql.*;

//Database connection 

public class Connect {
    public static Connection getConnect(){ //creating a method for convenient connection in other classes 
        Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="postgres";
        String username="postgres";
        String password="postpas";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                System.out.println("Connection OK");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return connection;
    }
    
    
}
