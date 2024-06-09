package com.rslakra.springbootjpa.controller;

import com.rslakra.springbootjpa.model.Cart;
import com.rslakra.springbootjpa.payload.CancelItemRequest;
import com.rslakra.springbootjpa.payload.CartRequest;
import com.rslakra.springbootjpa.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 21:00:39
 */
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/placeOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CartRequest placeOrder(@RequestBody CartRequest cartRequest) {
        Cart cart = CartRequest.toCart(cartRequest);
        cart = cartService.upsert(cart);
        return new CartRequest(cart);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public CartRequest getCart(@PathVariable(name = "id") Long cartId) {
        Cart cart = cartService.getCartById(cartId);
        return new CartRequest(cart);
    }

    @PostMapping(value = "/cancelItem", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CartRequest cancelOrderItem(@RequestBody CancelItemRequest cancelItemRequest) {
        Cart cart = cartService.cancelItem(cancelItemRequest.getCartId(), cancelItemRequest.getItemId());
        return new CartRequest(cart);
    }

//    /**
//     * Delete a specified role given the id
//     */
//    public ResponseEntity<Object> deleteRole(Long id) {
//        if (roleRepository.findById(id).isPresent()) {
//            roleRepository.deleteById(id);
//            if (roleRepository.findById(id).isPresent()) {
//                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
//            } else return ResponseEntity.ok().body("Successfully deleted specified record");
//        } else
//        return ResponseEntity.unprocessableEntity().body("No Records Found");
//    }

}
