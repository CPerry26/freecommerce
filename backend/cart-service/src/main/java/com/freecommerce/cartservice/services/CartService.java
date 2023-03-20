package com.freecommerce.cartservice.services;

import com.freecommerce.cartservice.entities.Cart;

/**
 * The interface describing the cart service. It is responsible for all business logic
 * related to cart operations.
 *
 * @author Cody Perry
 */
public interface CartService
{
    /**
     * Retrieve the cart associated with the given ID if it exists.
     *
     * @param cartId The ID of the cart to retrieve.
     *
     * @return The cart if it exists.
     */
    Cart getCartById(String cartId);

    /**
     * Update the cart with the associated ID with the updated cart info (should be add/remove products).
     *
     * @param cartId The ID of the cart to update.
     * @param updatedCart The updated version of the cart from the request.
     *
     * @return The updated cart.
     */
    Cart updateCart(String cartId, Cart updatedCart);

    /**
     * Create a new cart with no items.
     *
     * @return The ID of the new cart.
     */
    String createCart();

    /**
     * Remove the given cart (essentially remove all items). This doesn't return the cart
     * as it's really ephemeral.
     *
     * @param cartId The ID of the cart to delete.
     */
    void deleteCart(String cartId);
}
