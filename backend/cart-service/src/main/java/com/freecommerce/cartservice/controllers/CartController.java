package com.freecommerce.cartservice.controllers;

import com.freecommerce.cartservice.entities.Cart;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Controller interface defining the APIs for cart management.
 *
 * @author Cody Perry
 */
public interface CartController
{
    /**
     * Get the cart by ID. This should only be called when a user tries to view the cart.
     *
     * @param cartId The ID of the cart to retrieve.
     *
     * @return The cart with the specified ID if it exists.
     */
    @GetMapping(
            "/cart/{id}"
    )
    Cart getCartById(@PathVariable String cartId);

    /**
     * Update an existing cart. This should only be called for adding and removing individual items.
     *
     * @param cartId The ID of the existing cart.
     * @param updatedCart The updated cart of items.
     *
     * @return The updated cart.
     */
    @PutMapping(
            value = "/cart/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    Cart updateCart(@PathVariable String cartId, @RequestBody Cart updatedCart);

    /**
     * Create a new cart with no items. This should be called when a user logs in or to save on cache,
     * not until an item is added to the cart.
     *
     * @return The ID of the new cart.
     */
    @PostMapping(
            "/cart"
    )
    String createCart();

    /**
     * This endpoint effectively clears the cart. It should only be called either by the
     * user clearing the cart or when the cart turns into a real order.
     *
     * @param cartId The ID of the cart to delete.
     */
    @DeleteMapping(
            "/cart/{id}"
    )
    void deleteCart(@PathVariable String cartId);
}
