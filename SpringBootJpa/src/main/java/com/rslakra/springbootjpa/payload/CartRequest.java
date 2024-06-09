package com.rslakra.springbootjpa.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rslakra.springbootjpa.model.Cart;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 21:01:24
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartRequest {

    private Long id;
    private String name;
    private Set<ItemRequest> items;

    public CartRequest() {
    }

    public CartRequest(Cart cart) {
        this.id = cart.getId();
        this.name = cart.getName();
        if (cart.getItems() != null) {
            this.items = cart.getItems().stream().map(item -> new ItemRequest(item)).collect(Collectors.toSet());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ItemRequest> getItems() {
        return items;
    }

    public void setItems(Set<ItemRequest> items) {
        this.items = items;
    }

    public static Cart toCart(CartRequest cartRequest) {
        final Cart cart = new Cart();
        cart.setId(cartRequest.getId());
        cart.setName(cartRequest.getName());
        if (cartRequest.getItems() != null) {
            cart.setItems(cartRequest.getItems().stream().map(itemRequest -> ItemRequest.toItem(itemRequest)).collect(Collectors.toSet()));
        }

        return cart;
    }
}
