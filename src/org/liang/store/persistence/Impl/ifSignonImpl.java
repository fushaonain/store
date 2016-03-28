package org.liang.store.persistence.Impl;

import org.liang.store.bean.sign;
import org.liang.store.persistence.DBUtil;
import org.liang.store.persistence.Signon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by liangx on 2016-03-23.
 */
public class ifSignonImpl implements Signon {

    private static final String selectSQL = "select * from signon where username = ? and password = ?";
    @Override
    public sign ifSignon(sign sign) {
        sign result = null;

        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);

            preparedStatement.setString(1, sign.getUsername());
            preparedStatement.setString(2, sign.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                result = sign;
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
