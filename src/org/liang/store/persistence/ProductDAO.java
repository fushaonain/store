package org.liang.store.persistence;

import org.liang.store.bean.Product;

import java.util.List;

/**
 * Created by liangx on 2016-03-23.
 */
public interface ProductDAO {

    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);
}
