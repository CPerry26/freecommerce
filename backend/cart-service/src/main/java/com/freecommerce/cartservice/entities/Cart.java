package com.freecommerce.cartservice.entities;

/**
 * Simple POJO representing a cart. This likely turns into a record with a real
 * repository implementation.
 *
 * @author Cody Perry
 */
public class Cart
{
    private String id;

    public Cart(String cartId)
    {
        this.id = cartId;
    }

    public String getId()
    {
        return this.id;
    }
}
