package org.liang.store.web;

import org.liang.store.bean.Category;
import org.liang.store.bean.Product;
import org.liang.store.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by liangx on 2016-03-23.
 */
public class ViewCategoryServlet extends HttpServlet {

    private static final String VIEW_CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private String categoryId;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        categoryId = request.getParameter("categoryId");
        CatalogService service = new CatalogService();
        Category category = service.getCategory(categoryId);
        List<Product> productList = service.getProductListByCategory(categoryId);

        HttpSession session = request.getSession();
        session.setAttribute("category",category);
        session.setAttribute("productList",productList);

        request.getRequestDispatcher(VIEW_CATEGORY).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
