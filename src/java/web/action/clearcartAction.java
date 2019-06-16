/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.action;

import cart.ShoppingCart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.ViewManager;

/**
 *
 * @author AlbertSanchez
 */
public class clearcartAction extends Action 
{
    public void perform(HttpServletRequest req, HttpServletResponse resp)
    {
        ShoppingCart sc = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
        sc.clear();
        
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }
}
