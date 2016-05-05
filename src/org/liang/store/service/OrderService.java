package org.liang.store.service;

import org.liang.store.bean.Order;
import org.liang.store.persistence.Impl.OrderDAOImpl;
import org.liang.store.persistence.OrderDAO;

import java.util.List;

/*
/**
 * Created by liangx on 2016-04-04.
 */
public class OrderService {

    private OrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAOImpl();
    }

    public void insertToOrder(Order order){
        orderDAO.insertOrder(order);
    }
    public List<Order> viewOrder(String userId){
        return orderDAO.selectOrder(userId);
    }
}


