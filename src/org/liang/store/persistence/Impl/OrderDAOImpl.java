package org.liang.store.persistence.Impl;

import org.liang.store.bean.Account;
import org.liang.store.bean.Order;
import org.liang.store.persistence.DBUtil;
import org.liang.store.persistence.OrderDAO;
import org.liang.store.bean.Account;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by liangx on 2016-04-04.
 */


//未完成，需要你来做
public class OrderDAOImpl implements OrderDAO {


    private static final String getAccountById = "select * from ORDERS where userId = ?";
    /* private static final String InsertOrder = "INSERT INTO ORDERS (ORDERID, USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE,\n" +
             "      SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY,\n" +
             "      COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME,\n" +
             "      CREDITCARD, EXPRDATE, CARDTYPE, LOCALE)\n" +
             "    VALUES(?, ?, ?, ?, ?, ?,\n" +
             "      ?, ?, ?, ?, ?, ?,\n" +
             "      ?, ?, ?, ?, ?, ?, ?,\n" +
             "      ?, ?, ?, ?, ?, ?)";*/
    private static final String InsertOrder = "INSERT INTO ORDERS (USERID, ORDERDATE,TOTALPRICE)\n" + "VALUES(?, ?, ?)";
    @Override
    public void insertOrder(Order order) {

        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(InsertOrder);

            //preparedStatement.setInt(1,order.getOrderId());
            preparedStatement.setString(1,order.getUsername());
            preparedStatement.setDate(2, (java.sql.Date)(order.getOrderDate()));

            // preparedStatement.setString(10,order.getBillAddress1());
            //preparedStatement.setString(11,order.getBillAddress2());
            preparedStatement.setBigDecimal(3,order.getTotalPrice());
            boolean execute = preparedStatement.execute();

            //DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Order> selectOrder(String userId) {

        List<Order> itemList = new ArrayList<Order>();

        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getAccountById);

            preparedStatement.setString(1,userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                Order order = new Order();
                order.setOrderId(resultSet.getInt(1));
                order.setOrderDate(resultSet.getDate(3));
                order.setTotalPrice(resultSet.getBigDecimal(17));
                itemList.add(order);

            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return itemList;
    }
}
