package com.freecommerce.cartservice.repositories.impl;

import com.freecommerce.cartservice.entities.Cart;
import com.freecommerce.cartservice.repositories.CartRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * The implementation of the repository layer for carts. For now this just caches everything in memory.
 * In future this could be persisted to Mongo for say 'Save for Later' or use something like a distributed Redis cache.
 *
 * @author Cody Perry
 */
@Repository
public class CartRepositoryImpl implements CartRepository
{
    private ConcurrentMap<String, Cart> cartCache = new ConcurrentHashMap<>();

    /**
     * Retrieve the cart associated with the given ID if it exists.
     *
     * @param cartId The ID of the cart to retrieve.
     * @return The cart if it exists, null otherwise.
     */
    @Override
    public Cart getCartById(String cartId)
    {
        return cartCache.get(cartId);
    }

    /**
     * Update the cart with the associated ID with the updated cart info (should be add/remove products).
     *
     * @param cartId      The ID of the cart to update.
     * @param updatedCart The updated version of the cart from the request.
     * @return The updated cart.
     */
    @Override
    public Cart updateCart(String cartId, Cart updatedCart)
    {
        return cartCache.put(cartId, updatedCart);
    }

    /**
     * Create a new cart with no items.
     *
     * @return The ID of the new cart.
     */
    @Override
    public String createCart()
    {
        // Create new cart object.
        // TODO: Implement UUID generation
        Cart newCart = new Cart("fakeId");

        // Store the cart in cache.
        cartCache.put(newCart.getId(), newCart);

        // Return the ID.
        return newCart.getId();
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
        cartCache.remove(cartId);
    }
}
