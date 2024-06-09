package com.rslakra.springbootjpa.model;

import javax.persistence.*;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:25:52
 */
@Entity
@Table(name = "items")
public class Item extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Cart cart;

    // Hibernate requires no-args constructor
    public Item() {
    }

    public Item(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}