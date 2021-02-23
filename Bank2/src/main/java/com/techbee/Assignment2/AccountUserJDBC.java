package com.techbee.Assignment2;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountUserJDBC implements IAccountUserJDBC {

    @Override
    public AccountUser getUser() {
        return null;
    }

    @Override
    public List<AccountUser> getAllAccountusers() {
        List<AccountUser> Users = new ArrayList<>();

        Connection connection = (Connection) ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM AccountUser");

            //  Set users = new HashSet();

            while (rs.next()) {
                Users.add(extractUserFromResultSet(rs));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Users;
    }


    @Override
    public AccountUser getAccountUserByAccountNumber(double AccountNumber) {
        Connection connection = (Connection) ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM AccountUser WHERE accountNumber=" + AccountNumber);

            if (rs.next()) {
                AccountUser u=extractUserFromResultSet(rs);
                return u;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAccountUserAccountNumber(AccountUser User, double AccountNumber) {
        Connection connection = (Connection) ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE AccountUser SET accountNumber="+AccountNumber+" WHERE accountNumber =?" );
            ps.setDouble(1, User.getAccountNumber());

            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Update was successful!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void createAccountUser(AccountUser User) {
        Connection connection = (Connection) ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO AccountUser VALUES (?, ?, ?, ?,?,?)");
            ps.setDouble(1, User.getAccountNumber());
            ps.setDouble(2, User.getBalance());
            ps.setString(3, User.getFirstName());
            ps.setString(4, User.getLastName());
            ps.setString(5, User.getEmail());
            ps.setString(6, User.getPhoneNumber());

            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Insert was successful!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteAccountuser(double an) {

        Connection connection = (Connection) ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM AccountUser WHERE accountNumber=" + an);

            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Delete was successful!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    private AccountUser extractUserFromResultSet(ResultSet rs) throws SQLException {
        AccountUser user = new AccountUser();

        user.setAccountNumber( rs.getDouble("accountNumber") );
        user.setFirstName( rs.getString("firstname") );
        user.setLastName( rs.getString("lastname") );
        user.setBalance( rs.getDouble("balance") );
        user.setEmail(rs.getString("email"));
        user.setPhoneNumber(rs.getString("phonenumber"));

        return user;
    }
}
