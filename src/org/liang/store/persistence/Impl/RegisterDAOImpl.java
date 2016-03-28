package org.liang.store.persistence.Impl;

import org.liang.store.bean.Account;
import org.liang.store.bean.sign;
import org.liang.store.persistence.DBUtil;
import org.liang.store.persistence.RegisterDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by liangx on 2016-03-24.
 */
public class RegisterDAOImpl implements RegisterDAO {

    private static final String INSERTSIGNON = "insert into signon(username,password) values (?,?)";
    private static final String INSERTACCOUNT = "insert into account(userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone) values (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERTPROFILE = "insert into profile(userid,langpref,favcategory,mylistopt,banneropt) values (?, ?, ?, ? ,?)";
    @Override
    public void ResertSignon(sign signNow) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTSIGNON);

            preparedStatement.setString(1,signNow.getUsername());
            preparedStatement.setString(2,signNow.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ResertAccount(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTACCOUNT);

            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3,account.getFirstName());
            preparedStatement.setString(4,account.getLastName());
            preparedStatement.setString(5,account.getStatus());
            preparedStatement.setString(6,account.getAddress1());
            preparedStatement.setString(7,account.getAddress2());
            preparedStatement.setString(8,account.getCity());
            preparedStatement.setString(9,account.getState());
            preparedStatement.setString(10,account.getZip());
            preparedStatement.setString(11,account.getCountry());
            preparedStatement.setString(12,account.getPhone());

            ResultSet resultSet = preparedStatement.executeQuery();

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void ResertProfile(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERTPROFILE);

            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getLanguagePreference());
            preparedStatement.setString(3,account.getFavouriteCategoryId());
            preparedStatement.setString(4, String.valueOf(account.isListOption()));
            preparedStatement.setString(5, String.valueOf(account.isBannerOption()));

            ResultSet resultSet = preparedStatement.executeQuery();

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
