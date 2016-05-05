package org.liang.store.web;

import com.opensymphony.xwork2.ActionContext;
import org.liang.store.bean.Cart;
import org.liang.store.bean.CartItem;
import org.liang.store.bean.Item;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by liangx on 2016-04-13.
 */
public class CartAction implements Action {
    private String workingItemId;
    private String itemId;

    private Cart cart;
    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        cart = (Cart) session.get("cart");
        if (cart == null) {
            cart = new Cart();
        }
        return SUCCESS;
    }

    public String removeItemFromCart() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        cart = (Cart) session.get("cart");

        Item item = cart.removeItemById(workingItemId);

        if (item == null) {
            session.put("message", "Attempted to remove null CartItem from Cart.");
            return ERROR;
        }else {
            return SUCCESS;
        }
    }

    public String updateCartQuantities() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map request = (Map) context.get("request");
        Map session = context.getSession();
        cart = (Cart) session.get("cart");

        Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                int quantity = Integer.parseInt((String) request.get(itemId));
                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    cartItems.remove();
                }
            } catch (Exception e) {
                session.put("message", "The Quantities of Item must be Integer!");
                return ERROR;
            }
        }
        return SUCCESS;
    }

    public String newOrder() throws Exception{
        return SUCCESS;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getWorkingItemId() {
        return workingItemId;
    }

    public void setWorkingItemId(String workingItemId) {
        this.workingItemId = workingItemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
