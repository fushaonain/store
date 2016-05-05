package org.liang.store.web;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.liang.store.bean.Account;
import org.liang.store.bean.Cart;
import org.liang.store.bean.CartOne;
import org.liang.store.bean.Order;
import org.liang.store.service.AccountService;
import org.liang.store.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by liangx on 2016-04-14.
 */
public class OrderAction implements Action{

    private OrderService orderService = new OrderService();

    private List<Order> orderList;

    private Cart cart;
    private CartOne cartOne;

    ActionContext context = ActionContext.getContext();
    Map session = context.getSession();

    private Account account;
    private AccountService accountService = new AccountService();

    private String username;
    @Override
    public String execute() throws Exception {
        username = (String) session.get("username");
        account = accountService.selectAccountBYUserId(username);
        java.util.Date curDate = new java.util.Date();//新建一个util类型的date
        java.sql.Date date = new java.sql.Date(curDate.getTime());//进行日期的转换
        cart = (Cart)session.get("cart");
        cartOne = new CartOne();
        cartOne.addItem(cart);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("cartOne",cartOne);
        if(cart != null) {
            Order order = new Order();
            order.setUsername(username);
            order.setOrderDate(date);
            order.setTotalPrice(cart.getSubTotal());
            orderService.insertToOrder(order);
            cart.clearCart();
        }
        return SUCCESS;
    }

    public String listOrder() throws Exception{
        username = (String) session.get("username");
        orderList = orderService.viewOrder(username);

        return SUCCESS;
    }
    public String viewExistOrder() throws Exception{
        username = (String) session.get("username");
        account = accountService.selectAccountBYUserId(username);

        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CartOne getCartOne() {
        return cartOne;
    }

    public void setCartOne(CartOne cartOne) {
        this.cartOne = cartOne;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
