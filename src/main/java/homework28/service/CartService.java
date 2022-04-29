package homework28.service;

import homework28.model.Cart;

import java.math.BigDecimal;

public interface CartService {

    String print(Cart cart);

    BigDecimal getTotalPrice(Cart cart);
}
