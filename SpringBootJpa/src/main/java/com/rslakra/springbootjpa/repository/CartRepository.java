package com.rslakra.springbootjpa.repository;

import com.rslakra.springbootjpa.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @Created Aug 31, 2021 20:51:04
 */
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
