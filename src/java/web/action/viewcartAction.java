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
public class viewcartAction extends Action
{

    public void perform(HttpServletRequest req, HttpServletResponse resp) 
    {
        ViewManager.nextView(req, resp, "/view/viewcart.jsp");
    }
}
