package com.techbee.Assignment2;

import java.util.List;

public interface IAccountUserDao {

    List<AccountUser> getAllAccountusers();
   String getAccountUserByFirstName(String FirstName);

   String getAccountUserByAccountNumber(double AccountNumber);

    void updateAccountUserAccountNumber(AccountUser User,double AccountNumber);
    void createAccountUser(AccountUser User);
    void deleteAccountuser(AccountUser User);
}
