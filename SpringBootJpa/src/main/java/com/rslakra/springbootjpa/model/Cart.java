package com.rslakra.springbootjpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:25:30
 */
@Entity
@Table(name = "carts")
public class Cart extends NamedEntity {

    //    @OneToMany(targetEntity = Item.class)
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

    public Cart() {
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
        if (getItems() != null) {
            getItems().stream().forEach(item -> item.setCart(this));
        }
    }

    /**
     * @param item
     */
    public void removeItem(Item item) {
        getItems().remove(item);
        item.setCart(null);
        item = null;
    }

}