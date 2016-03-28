package org.liang.store.persistence.Impl;

import org.liang.store.bean.Category;
import org.liang.store.persistence.CategoryDao;
import org.liang.store.persistence.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangx on 2016-03-23.
 */
public class CategoryDaoImpl implements CategoryDao{

    private static final String getCategoryListString = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY";
    private static final String getCategoryString = "SELECT CATID AS categoryId,NAME,DESCN AS description FROM CATEGORY WHERE CATID=?";
    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<Category>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getCategoryListString);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Category category = new Category();
                category.setCategoryId(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
                categoryList.add(category);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }


        return categoryList;
    }

    @Override
    public Category getCategory(String categoryId) {
        Category category = null;
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(getCategoryString);
            pStatement.setString(1, categoryId);
            ResultSet resultSet = pStatement.executeQuery();
            if(resultSet.next())
            {
                category = new Category();
                category.setCategoryId(resultSet.getString(1));
                category.setName(resultSet.getString(2));
                category.setDescription(resultSet.getString(3));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(pStatement);
            DBUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
