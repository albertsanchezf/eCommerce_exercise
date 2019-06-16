package web.action;

import cart.ShoppingCart;
import javax.servlet.http.*;
import model.CategoryModel;
import web.ViewManager;

public class initAction extends Action {

    CategoryModel categoryModel;

    public initAction(CategoryModel categoryModel)
    {
        this.categoryModel = categoryModel;
    }

    public void perform(HttpServletRequest req, HttpServletResponse resp) 
    {
        if (req.getAttribute("categories") == null)
            req.setAttribute("categories", categoryModel.retrieveAll());
        
        if (req.getSession().getAttribute("shoppingCart") == null)
            req.getSession().setAttribute("shoppingCart", new ShoppingCart());
        
        ViewManager.nextView(req, resp, "/view/init.jsp");
    }
}
