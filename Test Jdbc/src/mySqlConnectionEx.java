import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mySqlConnectionEx {
    public static void main(String[] args) {
        //Database url
        String url="jdbc:mysql://localhost:3306/students";
        String username="root";
        String password="Shivam@2005";

        //establish connection
        try(Connection connection = DriverManager.getConnection(url,username,password)) {
            System.out.println("connected to the database");
            System.out.println(connection);
        }
        catch(SQLException e){
            System.out.println("connection failed:"+e.getMessage());
        }
    }
}



