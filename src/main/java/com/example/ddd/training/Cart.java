package com.example.ddd.training;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author vikash.yadav@piramal.com
 */
@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cart {
    private String cartId;
    private List<CartItem> cartItems;
    private Set<CartItem> removedCartItems;

    public Cart() {
        cartId = UUID.randomUUID().toString();
        cartItems = new ArrayList<>();
        removedCartItems = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId);
    }

    public void add(CartItem cartItem) {
        cartItems.add(cartItem);
        removedCartItems = removedCartItems.stream()
          .filter(cartItem1 -> !cartItem1.getProduct().getName().equals(cartItem.getProduct().getName()))
            .collect(Collectors.toSet());
    }

    public void remove(CartItem cartItem) {
        cartItems = cartItems.stream().filter(cartItem1 ->
            !cartItem1.getProduct().getName().equals(cartItem.getProduct().getName()))
          .collect(Collectors.toList());
        cartItems.add(cartItem);
    }
}
