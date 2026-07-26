import java.sql.*;

public class insertIntoDatabase {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
//        String querry = "INSERT INTO employees(id,name,job_title,salary) VALUES (3,'Harshit','Backend_developer',40000.0);";
        String querry = "INSERT INTO employees(id,name,job_title,salary) VALUES (4,'Adarsh','Java_developer',90000.0);";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Drivers loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //build connection
        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully.");
            Statement stmt = con.createStatement();
            int rows_affected = stmt.executeUpdate(querry); // to insert data

            if(rows_affected > 0){
                System.out.println("Insert successfull. " + rows_affected + " row(s) affected.");
            }else{
                System.out.println("Insertion failed. "+ rows_affected + "row(s) affected.");
            }

            stmt.close();
            con.close();
            System.out.println("\n Connections closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
