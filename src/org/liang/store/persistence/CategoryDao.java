package org.liang.store.persistence;

import org.liang.store.bean.Category;

import java.util.List;

/**
 * Created by liangx on 2016-03-23.
 */
public interface CategoryDao {

    List<Category> getCategoryList();

    Category getCategory(String categoryId);
}
