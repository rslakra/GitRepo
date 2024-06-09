package com.rslakra.springbootjpa.service;

import com.rslakra.springbootjpa.model.Item;
import com.rslakra.springbootjpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:52:15
 */
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * @return
     */
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

}
