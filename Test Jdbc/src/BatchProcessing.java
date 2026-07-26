import java.sql.*;

public class BatchProcessing {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";


        //loaded the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //now building the connections;
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection build successfully");
            con.setAutoCommit(false);
            Statement statement= con.createStatement();
            statement.addBatch("INSERT into employees(id,name,job_title,salary) VALUES (7,'Vashu','Hr_Manager',676767.00)");
            statement.addBatch("INSERT into employees(id,name,job_title,salary) VALUES (8,'Ram','Sales_Manager',976898.00)");
            statement.addBatch("INSERT into employees(id,name,job_title,salary) VALUES (9,'Raghav','VP_Manager',8789897.00)");
            int[] batchRes = statement.executeBatch();
            con.commit();
            System.out.println("Batch executed successfully");


            statement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully !!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
