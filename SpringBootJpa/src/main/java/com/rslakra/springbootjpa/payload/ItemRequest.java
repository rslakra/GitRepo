package com.rslakra.springbootjpa.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rslakra.springbootjpa.model.Item;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 21:04:37
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRequest {

    private Long id;
    private String name;

    public ItemRequest() {
    }

    public ItemRequest(Item item) {
        this.id = item.getId();
        this.name = item.getName();
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

    /**
     * @param itemRequest
     * @return
     */
    public static Item toItem(ItemRequest itemRequest) {
        final Item item = new Item();
        item.setId(item.getId());
        item.setName(itemRequest.getName());
        return item;
    }
}
