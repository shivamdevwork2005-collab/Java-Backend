package org.example;

import java.util.Scanner;

class Atm{
    float balance;
    int pin=2005;

    Atm(){
        checkPin();
    }

    public void checkPin(){
        System.out.print("Enter your pin:-");
        Scanner sc = new Scanner(System.in);
        int enterdPin = sc.nextInt();
        if(enterdPin == pin){
            menu();
        }else{
            System.out.println("Enter a valid pin.");
            checkPin();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("1. Check balance.");
        System.out.println("2. Withdraw Money.");
        System.out.println("3. Deposit Money.");
        System.out.println("4. Exit.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice:-");
        int choice = sc.nextInt();

        if(choice == 1){
            checkBalance();
        } else if (choice == 2) {
            withdrawMoney();
        }else if(choice == 3){
            depositeMoney();
        }else if(choice == 4){
            return;
        }else{
            System.out.println("Enter valid choice:-");
            menu();
        }
    }

    private void depositeMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount you want to deposit:-");
        double amt = sc.nextDouble();
        balance+=amt;
        System.out.println("Amout deposited successfully:-"+amt);
        menu();
    }

    private void withdrawMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount you want to withdraw:-");
        double amt = sc.nextDouble();
        if(amt<=balance){
            balance-=amt;
            System.out.println("Withdrawl successful of amount :-"+amt);
            menu();
        }
        else{
            System.out.println("Insufficient balance.");
            menu();
        }
    }

    private void checkBalance() {
        System.out.println("Your balance is :- "+ balance);
        menu();
    }

}


public class AtmMachine {

    public static void main(String[] args) {
        Atm obj = new Atm();
//        obj.checkPin();
    }
}