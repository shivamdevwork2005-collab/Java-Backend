import java.sql.*;

public class updateDatabase {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        String querry = "UPDATE employees SET job_title = 'full_stack_developer',salary=888800.0 where id=4;";

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
            int rows_affected = stmt.executeUpdate(querry); // to delete the data

            if(rows_affected > 0){
                System.out.println("Updation successfully. " + rows_affected + " row(s) affected.");
            }else{
                System.out.println("Updation failed. "+ rows_affected + "row(s) affected.");
            }

            stmt.close();
            con.close();
            System.out.println("\n Connections closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
