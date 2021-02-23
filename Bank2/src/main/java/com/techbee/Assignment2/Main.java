package com.techbee.Assignment2;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        boolean con=true;
        while(con){
            System.out.println("to test dao project press 1 or press 2 to for JDBC project or 3 to exit");
            int answer = scan.nextInt();
            if(answer==1)
                TestDao();
            else if(answer==2)
                TestJDBC();
            else
                break;
        }
    }
    public static void TestDao(){
        AccountUserDao userService=new AccountUserDao();
        System.out.println("Creating all users and printing their first and last name");

        AccountUser A1 = new AccountUser
                (123, 50, "Ali", "Beydoun", "ali@gmail.com","3136851552");
        AccountUser A2 = new AccountUser
                (1234, 50, "Sam", "Beydoun", "Sam@gmail.com","4136851552");
        AccountUser A3 = new AccountUser
                (12345, 500, "Deep", "Beydoun", "Deep@gmail.com","4136851552");

        userService.createAccountUser(A1);
        userService.createAccountUser(A2);
        userService.createAccountUser(A3);
        System.out.println("testing getAllAccountusers() function ");
        for (AccountUser AU:  userService.getAllAccountusers()
        ) {
            System.out.println(AU);
        }

        System.out.println("Finished printing all UserAccounts"+"\n"+"testing getAccountUserByAccountNumber function:let's try getting Sam");
        System.out.println(userService.getAccountUserByAccountNumber(123));
        System.out.println("testing getAccountUserByFirstName : let's try getting Sami ");
        System.out.println(userService.getAccountUserByFirstName("sam"));
        System.out.println("testing getAccountUserByFirstName : let's try getting a name whose not in the list:should print not found  ");
        System.out.println(userService.getAccountUserByFirstName("samii"));
        System.out.println("deleteAccountuser : let's try deleting User 1 :ALi");
        userService.deleteAccountuser(A1);
        System.out.println("Now A1 is deleted let's confirm it and print the remaining ");

        for (AccountUser AU:  userService.getAllAccountusers()
        ) {
            System.out.println(AU);
        }

        System.out.println("testing updateAccountUserAccountNumber for Deep and setting it 9999999");
        userService.updateAccountUserAccountNumber(A3,9999999);
        System.out.println("let's see if deep's account number is updated and set to 9999999");
        System.out.println(userService.getAccountUserByAccountNumber(9999999));
    }
    public static void TestJDBC()
    {Scanner scan=new Scanner(System.in);
        AccountUserJDBC userService2=new AccountUserJDBC();
        System.out.println("Enter a unique AccountNumber");
        double accountNumber= scan.nextDouble();
        AccountUser A1 = new AccountUser
                (accountNumber, 50, "Ali", "Beydoun", "ali@gmail.com","3136851552");
        userService2.createAccountUser(A1);
        System.out.println("testing getAllAccountusers() function ");
        for (AccountUser AU:  userService2.getAllAccountusers()
        ) {
            System.out.println(AU);
        }
        System.out.println("testing deleteAccountusers(double an) function: Enter any  account number from the list ");
        double an=scan.nextDouble();
        userService2.deleteAccountuser(an);
        System.out.println("Printing all users again ");
        for (AccountUser AU:  userService2.getAllAccountusers()
        ) {
            System.out.println(AU);
        }
        System.out.println("testing getAccountUserByAccountNumber(double an) function: Enter any  account number from the list ");
        double an2=scan.nextDouble();
        System.out.println((userService2.getAccountUserByAccountNumber(an2)).toString());
        return;
    }
}
