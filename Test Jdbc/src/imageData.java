import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.xml.transform.Result;
import java.io.*;
import java.util.Scanner;

public class imageData {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        String img_path="C:\\Users\\ganes\\Downloads\\pic.jpeg";

        String querry = "INSERT INTO image_table (image_data) VALUES (?)"; //PREPARED STMT.

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

            FileInputStream fileInputStream = new FileInputStream(img_path); //this conv img to binary form.
            byte[] img_data=new byte[fileInputStream.available()];
            fileInputStream.read(img_data); //storing into array . img ko folder se nikal ke java var me dal li hai;

            PreparedStatement preparedStatement = con.prepareStatement(querry);
            preparedStatement.setBytes(1,img_data); //array of bytes;

            int affectedRows=preparedStatement.executeUpdate();
            if(affectedRows>0){
                System.out.println("Insertion of image successfully done.");
            }else{
                System.out.println("Insertion of image failed.");
            }


            con.close();
            preparedStatement.close();
            System.out.println("Connection closed !!!.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
