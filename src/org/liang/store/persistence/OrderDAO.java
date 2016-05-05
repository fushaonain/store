package org.liang.store.persistence;

import org.liang.store.bean.Order;

import java.util.List;

/**
 * Created by liangx on 2016-04-04.
 */
public interface OrderDAO {
    void insertOrder(Order order);
    List<Order> selectOrder(String userId);
}
