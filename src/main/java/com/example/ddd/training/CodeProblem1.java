package com.example.ddd.training;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author vikash.yadav@piramal.com
 *
 * Code Problem 1
 *
 *  Add a “Apple Pencil” to a Cart
 *  --
 *   --
 *
 *  Note:
 *  Please do not create User class.
 *  Please do not create ProductCategory, Variant, Colour, etc classes.
 *
 *  Code Problem 2
 *
 *  Add a “Sony Wireless headphone” to a Cart
 *
 *   Code Problem 4
 *
 * Remove already added Item “Apple Pencil” (with all its quantities) from Cart.
 *
 * Code Problem 5
 *
 *  As a business User, I would like to know which Products (Product’s name) were removed from Cart.
 *  --
 *  Note – Please do not create business User class.  You could have a method on Cart class or some other class, which returns list of Products names which were removed from Cart.
 *
 *  Code Problem 6
 *
 *  As a business User, I would like to differentiate between two Carts, even if they contain same Item ( both carts have Product “Sony Wireless headphone” with 1 quantity)
 *  --
 *  Note –
 *  Two carts where items are same, equality on Carts should return false
 *  Cart cart1 = Cart();
 *  Cart cart2 = Cart();
 *  Item item1 = new Item(new Product(”Sony Wireless headphone"), 1);
 *  Item item2 = new Item(new Product(”Sony Wireless headphone"), 1);
 *  cart1.add(item1);
 *  cart2.add(item2);
 *  cart1.equals(cart2)  =>  should return false
 *
 *  cart1.equals(cart1) => should be true
 *
 */
@Component
@Slf4j
public class CodeProblem1 {
    private Cart cart;

    public void addCartItem(CartItem cartItem) {
        final Cart cart = getCart();
        cart.add(cartItem);
    }

    public void removeItem(CartItem cartItem) {
        final Cart cart = getCart();
        cart.remove(cartItem);
    }

    public Cart getCart() {
        if (Objects.isNull(cart)) {
            cart = new Cart();
        }
        return cart;
    }

    public void displayRemovedItems() {
        log.info("Removed item names:{}", cart.getRemovedCartItems());
    }
}
