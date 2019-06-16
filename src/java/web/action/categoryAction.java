/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryModel;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author AlbertSanchez
 */
public class categoryAction extends Action {

    CategoryModel categoryModel;
    ProductModel productsModel;

    public categoryAction(CategoryModel categoryModel, ProductModel productsModel)
    {
        this.categoryModel = categoryModel;
        this.productsModel = productsModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) 
    {
        // We request the category Id from the URL parameter 'categoryid'
        int categoryId = Integer.parseInt(req.getParameterValues("categoryid")[0]);
        
        req.setAttribute("items", productsModel.retrieveAllbyCategory(categoryId));

        ViewManager.nextView(req, resp, "/view/category.jsp");
    }

    
}
