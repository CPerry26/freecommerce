package com.freecommerce.cartservice.services.impl;

import com.freecommerce.cartservice.entities.Cart;
import com.freecommerce.cartservice.repositories.CartRepository;
import com.freecommerce.cartservice.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The implementation of the cart service, responsible for all cart operations.
 *
 * @author Cody Perry
 */
@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartRepository cartRepository;

    /**
     * Retrieve the cart associated with the given ID if it exists.
     *
     * @param cartId The ID of the cart to retrieve.
     * @return The cart if it exists.
     */
    @Override
    public Cart getCartById(String cartId)
    {
        return this.cartRepository.getCartById(cartId);
    }

    /**
     * Update the cart with the associated ID with the updated cart info (should be add/remove products).
     *
     * @param cartId The ID of the cart to update.
     * @param updatedCart The updated version of the cart from the request.
     * @return The updated cart.
     */
    @Override
    public Cart updateCart(String cartId, Cart updatedCart)
    {
        return this.cartRepository.updateCart(cartId, updatedCart);
    }

    /**
     * Create a new cart with no items.
     *
     * @return The ID of the new cart.
     */
    @Override
    public String createCart()
    {
        return this.cartRepository.createCart();
    }

    /**
     * Remove the given cart (essentially remove all items). This doesn't return the cart
     * as it's really ephemeral.
     *
     * @param cartId The ID of the cart to delete.
     */
    @Override
    public void deleteCart(String cartId)
    {
        this.cartRepository.deleteCart(cartId);
    }
}
