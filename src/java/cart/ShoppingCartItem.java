/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software
 * except in compliance with the terms of the license at:
 * http://developer.sun.com/berkeley_license.html
 */

package cart;

import entity.Product;

/**
 *
 * @author juanluis
 */
public class ShoppingCartItem {

    Product product;
    int quantity;
    
    public ShoppingCartItem(Product product)
    {
        this.product = product;
        this.quantity = 1;
    }
    
    public Product getProduct()
    {
        return product;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }   
    
    public double getTotal()
    {
        double total;
        total = quantity * product.getPrice();
        
        return total;
    }        
    
}