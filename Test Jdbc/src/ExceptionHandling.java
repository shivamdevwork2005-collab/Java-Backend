import java.util.*;
import java.util.Scanner;

public class ExceptionHandling {
    public static void helper (int dividend,int divisor) throws ArithmeticException{
        System.out.println("The res is:-" + dividend/divisor);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            System.out.print("Enter dividend:- ");
            int dividend = sc.nextInt();
            System.out.print("Enter your divisor:- ");
            int divisor = sc.nextInt();
        try{
            int result = dividend / divisor;
            System.out.println("The result is :- " + result);
        } catch (Exception e) {
            System.out.println("Divisor cant be 0 exception is:- " + e.getMessage());
        }

        // multiple try catch
         int[] arr=new int[5];
         try {
            arr[6] = 10 ;
         }
         catch (ArithmeticException e) {
             System.out.println(e.getMessage());
        }
         catch (ArrayIndexOutOfBoundsException e) {
             System.out.println(e.getMessage());
        }

         //nested try catch
        int[] crr=new int[5];
         try{
             System.out.println("I am in first try block.");
             try{
                 crr[7]=10;
             } catch (Exception e) {
                 System.out.println(e.getMessage());
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

//         //try catch finnly
//        int[]ans=new int[3];
//        try{
//            System.out.println("Try with finally.");
//            ans[9]=99;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        finally {
//            System.out.println("finaly executed.");
//        }

        //throw and throws;
        int age;
        System.out.print("Enter your age:- ");
        age=sc.nextInt();
        if(age<18){
            throw new RuntimeException("Sorry are not eleigible to vote.");
        }else{
            System.out.println("You are eleigible to vote.");
        }

        //throws;
        helper(10,0);


    }
}

