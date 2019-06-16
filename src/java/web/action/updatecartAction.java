/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import entity.Product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductModel;
import web.ViewManager;

/**
 *
 * @author AlbertSanchez
 */
public class updatecartAction extends Action
{
    ProductModel productModel;

    public updatecartAction(ProductModel productModel)
    {
        this.productModel = productModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) 
    {   
        int itemid = 0;
        String quantity = "";
        ShoppingCart sc = null;
        Product product = null;
        
        itemid = Integer.parseInt(req.getParameterValues("itemid")[0]);
        quantity = (String) req.getParameterValues("quantity")[0];
        product = productModel.retrieveById(itemid);
        
        sc = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
        sc.update(product, quantity);
        
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }
}
