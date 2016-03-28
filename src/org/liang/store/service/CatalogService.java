package org.liang.store.service;

import org.liang.store.bean.Category;
import org.liang.store.bean.Item;
import org.liang.store.bean.Product;
import org.liang.store.persistence.CategoryDao;
import org.liang.store.persistence.Impl.CategoryDaoImpl;
import org.liang.store.persistence.Impl.ItemDAOImpl;
import org.liang.store.persistence.Impl.ProductDAOImpl;
import org.liang.store.persistence.ItemDAO;
import org.liang.store.persistence.ProductDAO;

import java.util.List;

/**
 * Created by liangx on 2016-03-23.
 */
public class CatalogService {
    private CategoryDao categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;

    public CatalogService()
    {
        categoryDAO = new CategoryDaoImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
    }


    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }


    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }
}
