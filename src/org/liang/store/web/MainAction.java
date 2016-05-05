package org.liang.store.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.liang.store.bean.*;
import org.liang.store.service.AccountService;
import org.liang.store.service.CatalogService;
import org.liang.store.web.Action;

import java.util.List;
import java.util.Map;

/**
 * Created by liangx on 2016-04-11.
 */
public class MainAction extends ActionSupport implements Action{
    private String categoryId;
    private String productId;
    private String itemId;
    private String workingItemId;
    private String keyword;
    private boolean isInStock;
    private CatalogService catalogService = new CatalogService();

    private boolean authenticated;

    private Category category;
    private Product product;
    private Item item;
    private Cart cart;
    private List<Product> productList;
    private List<Item> itemList;

    ActionContext context = ActionContext.getContext();
    Map session = context.getSession();
    public String execute() throws Exception{
        return "main";
    }
    public String viewCategory() throws Exception{
        category = catalogService.getCategory(categoryId);
        productList = catalogService.getProductListByCategory(categoryId);

        return Action.SUCCESS;

    }

    public String viewProduct() throws Exception{
        product = catalogService.getProduct(productId);
        itemList = catalogService.getItemListByProduct(productId);

        return Action.SUCCESS;
    }

    public String viewItem() throws Exception{
        item = catalogService.getItem(itemId);

        return Action.SUCCESS;
    }

    public String addItemToCart() throws Exception{
        ActionContext context = ActionContext.getContext();
        Map session = context.getSession();
        cart = (Cart) session.get("cart");
        if (cart == null) {
            cart = new Cart();
        }

        if (cart.containsItemId(workingItemId)) {
            cart.incrementQuantityByItemId(workingItemId);
        } else {
            isInStock = catalogService.isItemInStock(workingItemId);
            Item item = catalogService.getItem(workingItemId);
            cart.addItem(item, isInStock);
            session.put("cart",cart);
        }

        return Action.SUCCESS;
    }

    public String search() throws Exception{
        productList = catalogService.searchProductList(keyword);
        return Action.SUCCESS;

    }



    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getWorkingItemId() {
        return workingItemId;
    }

    public void setWorkingItemId(String workingItemId) {
        this.workingItemId = workingItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
