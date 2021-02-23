package com.techbee.Assignment2;

import java.util.List;

public interface IAccountUserJDBC {
    AccountUser getUser();
    List<AccountUser> getAllAccountusers();

    AccountUser getAccountUserByAccountNumber(double AccountNumber);

    void updateAccountUserAccountNumber(AccountUser User,double AccountNumber);
    void createAccountUser(AccountUser User);
    void deleteAccountuser(double an);
}
