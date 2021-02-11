package com.techbee.Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String newEmail = "";
        boolean invalid = true;
        Account A1 = new Account
                (123, 50, "Ali", "Beydoun", "ali@gmail.com","3136851552");
        System.out.println(A1.toString());
        A1.setBalance(-4);//should print invalid balance
        A1.setFirstName("Rayan");
        A1.setFirstName("A");// should print Invalid firstname
        A1.setLastName("EL-Beydoun");
        A1.setLastName("A");//should print Invalid firstname
        A1.setPhoneNumber("1");//should print Invalid Phonenumber
        A1.depositChecks(10);
        A1.depositChecks(-1);
        A1.withdrawChecks(10);
        A1.withdrawChecks(100);
        //Asking the user to enter a new email and giving example about try -catch and throw exception
        do {
            try {
                System.out.print("Enter a new email to change it: note:it should contain @");
                newEmail = scan.nextLine();
                A1.setEmail(newEmail);
                invalid = false;
                System.out.println(A1.toString());
            } catch (InputMismatchException e) {
                System.out.print("Invalid Email.  ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (invalid);
//Allowing the user to inout options
        System.out.println("press '1' to Show Account Balance,'2' to Deposit Money,'3'to Withdraw Money and '4' to Exit");
        String option = scan.nextLine();
        switch (option) {
            case "1":
                System.out.println("Account Balance" + A1.getBalance());
                break;
            case "2":
                System.out.println("Enter the amount of money you want to deposit");
                double AmountDeposited = scan.nextDouble();
                A1.depositChecks(AmountDeposited);
                break;
            case "3":
                System.out.println("Enter the amount of money you want to withdraw");
                double AmountWithdrawn = scan.nextDouble();
                A1.withdrawChecks(AmountWithdrawn);
                break;
            case "4":
                System.out.println("Exiting");
                break;
        }
    }

}
