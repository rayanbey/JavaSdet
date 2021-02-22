package com.techbee.Assignment2;

import java.util.ArrayList;
import java.util.List;

public class AccountUserDao implements IAccountUserDao {

    List<AccountUser> Users = new ArrayList<>();
    public AccountUserDao() {
    }

    @Override
    public void createAccountUser(AccountUser User) {
        Users.add(User);
    }

    @Override
    public List<AccountUser> getAllAccountusers() {
         return Users;
    }
    @Override
    public String getAccountUserByFirstName(String FirstName)
    {
        for (AccountUser user : Users)
            if (user.getFirstName().equalsIgnoreCase(FirstName)) {
                return user.toString();
            }

                 return ("not found");
    }

    @Override
    public String getAccountUserByAccountNumber(double AccountNumber) {
        for (AccountUser user : Users)
            if (user.getAccountNumber() == AccountNumber) {
                return user.toString();
            }
        return ("not found");
    }

    @Override
    public void updateAccountUserAccountNumber(AccountUser User,double AccountNumber) {
                System.out.println(User.setAccountNumber(AccountNumber));
    }

    @Override
    public void deleteAccountuser(AccountUser User) {
                System.out.println("removing user :"+"\n"+Users.remove(User)+User.toString());
    }


}
