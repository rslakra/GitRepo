package com.rslakra.springbootjpa.service;

import com.rslakra.springbootjpa.exception.InvalidRequestException;
import com.rslakra.springbootjpa.exception.NoRecordFoundException;
import com.rslakra.springbootjpa.model.Cart;
import com.rslakra.springbootjpa.model.Item;
import com.rslakra.springbootjpa.repository.CartRepository;
import com.rslakra.springbootjpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:55:52
 */
@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ItemRepository itemRepository;

    /**
     * @return
     */
    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long cartId) {
        return cartRepository.getOne(cartId);
    }

    public Cart upsert(Cart cart) {
        return cartRepository.save(cart);
    }

    public void delete(Long cartId) {
        Cart cart = cartRepository.getOne(cartId);
        cartRepository.delete(cart);
    }

    /**
     * @param cartId
     * @param itemId
     * @return
     */
    public Cart cancelItem(final Long cartId, final Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new NoRecordFoundException("cartId:%d", cartId));
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new NoRecordFoundException("itemId:%d", itemId));
        if (!Objects.equals(item.getCart().getId(), cartId)) {
            throw new InvalidRequestException("Item does not belong to cart!");
        }

        cart.removeItem(item);
        cart = cartRepository.save(cart);
        return cart;
    }

}
