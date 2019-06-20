package com.cedz.kata.shoppingcart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Product, Integer> products = new HashMap<>();

    public Map<Product,Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product) {

        if(!products.containsKey(product)) {
            products.put(product, 1);
        } else {
            products.put(product, products.get(product) +1);
        }
    }
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;


        for(Map.Entry<Product, Integer> productEntry : products.entrySet()) {
            total = total.add(productEntry.getKey().getPrice().multiply(new BigDecimal(productEntry.getValue())));
        }
        return total;

    }

}
