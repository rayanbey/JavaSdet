package com.techbee.Assignment2;

public class Main {

    public static void main(String[] args) {


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
}
