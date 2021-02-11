package com.techbee.Assignment2;

import java.util.InputMismatchException;

public class Account {
    private double accountNumber;
    private double balance;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public Account(double accountNumber, double balance, String firstName, String lastName, String email, String phoneNumber) {
        setAccountNumber(accountNumber);
        setBalance(balance);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0)
            this.balance = balance;
        else
            System.out.println("Invalid Balance");

    }
    public void depositChecks(double balance) {
        if (balance > 0){
            this.balance += balance;
            System.out.println("Name:"+getFirstName()+getLastName()+" your new balance is + "+this.balance); }
        else
            System.out.println("Name:"+getFirstName()+getLastName()+" Invalid Balance it should be >0");
    }
    public void withdrawChecks(double balance) {
        if (this.balance >=balance){
            this.balance-=balance;
            System.out.println("Name:"+getFirstName()+getLastName()+" your new balance is + "+this.balance); }
        else
            System.out.println("Name:"+getFirstName()+getLastName()+" You don't have enough balance to withdraw");
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 1) {
            this.firstName = firstName;
            System.out.println("Your new firstName is : " + this.firstName);
        }
        else
            System.out.println(firstName+":Invalid firstName");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 1) {
            this.lastName = lastName;
            System.out.println("Your new lastName is : "+this.lastName);
        }
        else
            System.out.println(lastName+":Invalid lastName");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!email.contains("@"))
            throw new InputMismatchException();
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()==10)
        this.phoneNumber = phoneNumber;
        else System.out.println("Invalid Phone number");
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
