package org.liang.store.bean;

//import com.ibatis.common.util.PaginatedArrayList;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

public class CartOne implements Serializable {

    private static final long serialVersionUID = 8329559983943337176L;
    private Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());
    //private List<CartItem> itemList1 = new ArrayList<CartItem>();
    private List<CartItem> itemList1 = new ArrayList<CartItem>();
    public void setCartItems(Cart cart) {
        //return itemList.iterator();
        itemList1 = cart.getCartItemList();
    }
    public Iterator<CartItem> getCartItems() {
        return itemList1.iterator();
    }
    public List<CartItem> getCartItemList() {
        return itemList1;
    }

    public int getNumberOfItems() {
        return itemList1.size();
    }

    public Iterator<CartItem> getAllCartItems() {
        return itemList1.iterator();
    }
    /*public Iterator<CartItem> setAllCartItems(Cart cart) {
        itemList1 =  cart.getAllCartItems();
        return itemList1.iterator();
    }*/
    /*public void addItem(Item item) {*/
    public void addItem(Cart cart) {
        //CartItem cartItem = (CartItem) itemMap.get(item.getItemId());
        Iterator<CartItem> items = cart.getCartItems();
        if(items.hasNext()){
            CartItem cartItem = items.next();
            /*cartItem.setItem(item);
            cartItem.setQuantity(0);
            cartItem.setInStock(isInStock);*/
            //itemMap.put(cartItem);

            itemList1.add(cartItem);
        }
    }
}
