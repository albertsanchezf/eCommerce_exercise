package cart;

import entity.Product;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author juanluis
 */
public class ShoppingCart {
    
    List<ShoppingCartItem> itemsList = new ArrayList<ShoppingCartItem>();
    
    public synchronized void addItem(Product product)
    {
        boolean hasProduct = false;
        for (ShoppingCartItem item : itemsList)
        {
            if (item.getProduct().equals(product))
            {
                hasProduct = true;
                item.setQuantity(item.getQuantity()+1);
            }
        }
        
        if (!hasProduct)
            itemsList.add(new ShoppingCartItem(product));
    }
    
    public synchronized void update(Product product, String quantity)
    {
        for (ShoppingCartItem item : itemsList)
        {
            if (item.getProduct().equals(product))
            {
                if (Integer.parseInt(quantity) > 0)
                {
                    item.setQuantity(Integer.parseInt(quantity));
                    break;
                }
                else
                    itemsList.remove(item);
                    break;
            }
        }

    } 
    
    public synchronized List<ShoppingCartItem> getItems()
    {
        return itemsList;
    }
    
    public synchronized int getNumberOfItems()
    {
        int n_items = 0;
        for (ShoppingCartItem item : itemsList)
        {
            n_items = n_items + item.getQuantity();
        }
            return n_items;
    } 
    
    public synchronized double getTotal()
    {
        double total = 0;
        DecimalFormat df = new DecimalFormat("#.##");
        
        for (ShoppingCartItem item : itemsList)  
            total = total + item.getQuantity() * item.getProduct().getPrice();
                
        return Double.valueOf(df.format(total));
    } 
    
    public synchronized void clear()
    {
        itemsList.clear();
    }

}