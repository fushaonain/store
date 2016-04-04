package org.liang.store.persistence.Impl;

import org.liang.store.bean.Account;
import org.liang.store.persistence.AccountDAO;
import org.liang.store.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by liangx on 2016-03-29.
 */
public class AccountDAOImpl implements AccountDAO {

    private static final String getAccountById = "select * from account where userId = ?";
    @Override
    public Account getAccountBy(String userId) {
        Account account = new Account();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getAccountById);

            preparedStatement.setString(1,userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                account.setEmail(resultSet.getString(2));
                account.setFirstName(resultSet.getString(3));
                account.setLastName(resultSet.getString(4));
                account.setStatus(resultSet.getString(5));
                account.setAddress1(resultSet.getString(6));
                account.setAddress2(resultSet.getString(7));
                account.setCity(resultSet.getString(8));
                account.setState(resultSet.getString(9));
                account.setZip(resultSet.getString(10));
                account.setCountry(resultSet.getString(11));
                account.setPhone(resultSet.getString(12));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }
}
