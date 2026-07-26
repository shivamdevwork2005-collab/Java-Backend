import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        String querry = "select * from employees;";

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
            ResultSet res = stmt.executeQuery(querry);
            while(res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                String job_title = res.getString("job_title");
                double salary = res.getDouble("salary");

                System.out.println();
                System.out.println("============= Data ==============");
                System.out.println("id:- "+id);
                System.out.println("name:- "+name);
                System.out.println("job_title:- "+job_title);
                System.out.println("Salary:- "+salary);
            }
            // now it's our res to close all classes and interfaces of driver which we loaded.
            res.close();
            stmt.close();
            con.close();
            System.out.println("\n Connections closed successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
