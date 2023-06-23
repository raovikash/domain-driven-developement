package com.example.ddd.training;

import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author vikash.yadav@piramal.com
 */
@SpringBootTest
public class CodeProblem1Test {

    @Autowired
    private CodeProblem1 codeProblem1;

//    @Test
//    public void test_addProduct_sonyWirelessHeadPhone() {
//        codeProblem1.addProduct(new Product("Apple Pencil", 1));
//        Assertions.assertEquals(1, codeProblem1.getCart().getProducts().size());
//        Assertions.assertEquals("Apple Pencil", codeProblem1.getCart().getProducts().get(0));
//
//        codeProblem1.addProduct(new Product("Sony Wireless headphone", 1));
//        Assertions.assertEquals(2, codeProblem1.getCart().getProducts().size());
//        Assertions.assertEquals("Sony Wireless headphone", codeProblem1.getCart().getProducts().get(1));
//
//    }

    @Test
    public void test_equalCart() {
        Cart cart1 = new Cart();
        cart1.add(new CartItem(new Product("Sony Wireless headphone", new Price(new BigDecimal(10))), 1));
        Cart cart2 = new Cart();
        cart2.add(new CartItem(new Product("Sony Wireless headphone", new Price(new BigDecimal(110))), 1));
        Assertions.assertFalse(cart1.equals(cart2));
        Assertions.assertTrue(cart1.equals(cart1));
    }
}
