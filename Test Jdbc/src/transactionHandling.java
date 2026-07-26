import java.sql.*;
import java.util.Scanner;

public class transactionHandling {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        String withdrawQuerry="UPDATE accounts SET balance = balance - ? where account_number = ? ";
        String depositQuerry="UPDATE accounts SET balance = balance + ? where account_number = ? ";

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
            try {
                PreparedStatement withdrawStatement = con.prepareStatement(withdrawQuerry);
                PreparedStatement depositeStatement = con.prepareStatement(depositQuerry);

                withdrawStatement.setDouble(1, 500.00);
                withdrawStatement.setString(2, "account456");

                depositeStatement.setDouble(1, 500.00);
                depositeStatement.setString(2, "account123");

                int rows_affected_withdraw = withdrawStatement.executeUpdate();
                int rows_affected_deposite = depositeStatement.executeUpdate();

                if(rows_affected_withdraw >0 && rows_affected_deposite >0){
                    con.commit();
                    System.out.println("Transaction successful");
                }
                else{
                    con.rollback();
                    System.out.println("Transaction failed.");
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            con.close();
            System.out.println();
            System.out.println("Connection closed successfully !!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
