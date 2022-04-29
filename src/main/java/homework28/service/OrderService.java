package homework28.service;

import homework28.model.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order getById(Long id);

    Order getByUserId(Long userId);

    List<Order> getAll();

    Order update(Long id, Order order);

    void deleteById(Long id);
}
