package org.liang.store.web;

import org.liang.store.bean.Product;
import org.liang.store.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by liangx on 2016-04-10.
 */
public class NowSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CatalogService service = new CatalogService();

        response.setContentType("text/xml");
        PrintWriter out =  response.getWriter();

        if(request.getParameter("search-text") != null){
            String key = request.getParameter("search-text");
            if(key.length() != 0){
                String json = "[";
                List<Product> productList = service.searchProductList(key);
                for (int i = 0;i < productList.size();i++){
                    json += "\"" + productList.get(i).getName() + "\"" + ",";
                }
                json = json.substring(0,json.length()-1>0?json.length()-1:1);
                json += "]";
                System.out.println("json:" + json);
                out.println(json);
            }
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
