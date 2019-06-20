package com.cedz.kata.shoppingcart

import spock.lang.Specification

class ShoppingCartSpec extends  Specification {


    def "Test add Product" () {
        given:
        ShoppingCart cart = new ShoppingCart()
        Product carrot = new Product("Carrots", BigDecimal.ONE)
        Product onion = new Product("Onion", BigDecimal.TEN)


        when:
        cart.addProduct(carrot)
        cart.addProduct(onion)
        cart.addProduct(onion)


        then:
        cart.getProducts().size() == 2
        cart.getProducts().get(carrot) == 1
        cart.getProducts().get(onion) == 2


    }


    def "Test calculate simple price" () {
        given:
        ShoppingCart cart = new ShoppingCart()

        Product carrot = new Product("Carrots", BigDecimal.ONE)
        cart.addProduct(carrot)


        expect:
        BigDecimal.ONE.compareTo(cart.calculateTotal()) == 0

    }
}
