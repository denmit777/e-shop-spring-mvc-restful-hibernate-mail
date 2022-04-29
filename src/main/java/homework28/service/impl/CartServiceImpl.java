package homework28.service.impl;

import homework28.model.Cart;
import homework28.model.Good;
import homework28.service.CartService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CartServiceImpl implements CartService {

    @Override
    public String print(Cart cart) {
        StringBuilder sb = new StringBuilder("You have already chosen:\n");

        int count = 1;

        for (Good el : cart.getGoods()) {
            sb.append(count + ") " + el.getName() + " " + el.getPrice() + " $\n");
            count++;
        }
        return sb.toString();
    }

    @Override
    public BigDecimal getTotalPrice(Cart cart) {
        BigDecimal count = BigDecimal.valueOf(0);

        for (Good good : cart.getGoods()) {
            count = count.add(good.getPrice());
        }
        return count;
    }
}
