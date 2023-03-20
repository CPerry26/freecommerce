package com.freecommerce.cartservice.controllers.impl;

import com.freecommerce.cartservice.controllers.CartController;
import com.freecommerce.cartservice.entities.Cart;
import com.freecommerce.cartservice.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Cart controller implementation. Handles all functionality related to the cart.
 *
 * @author Cody Perry
 */
@RestController
public class CartControllerImpl implements CartController
{
    @Autowired
    private CartService cartService;

    /**
     * Get the cart by ID. This should only be called when a user tries to view the cart.
     *
     * @param cartId The ID of the cart to retrieve.
     * @return The cart with the specified ID if it exists.
     */
    @Override
    public Cart getCartById(String cartId)
    {
        return this.cartService.getCartById(cartId);
    }

    /**
     * Update an existing cart. This should only be called for adding and removing individual items.
     *
     * @param cartId      The ID of the existing cart.
     * @param updatedCart The updated cart of items.
     * @return The updated cart.
     */
    @Override
    public Cart updateCart(String cartId, Cart updatedCart)
    {
        return this.cartService.updateCart(cartId, updatedCart);
    }

    /**
     * Create a new cart with no items. This should be called when a user logs in or to save on cache,
     * not until an item is added to the cart.
     *
     * @return The ID of the new cart.
     */
    @Override
    public String createCart()
    {
        return this.cartService.createCart();
    }

    /**
     * This endpoint effectively clears the cart. It should only be called either by the
     * user clearing the cart or when the cart turns into a real order.
     *
     * @param cartId The ID of the cart to delete.
     */
    @Override
    public void deleteCart(String cartId)
    {
        this.cartService.deleteCart(cartId);
    }
}
