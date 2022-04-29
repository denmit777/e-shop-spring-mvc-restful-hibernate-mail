package homework28.dao;

import homework28.model.Order;

import java.util.List;

public interface OrderDAO {

    void save(Order order);

    Order getById(Long id);

    Order getByUserId(Long userId);

    List<Order> getAll();

    void deleteById(Long id);
}
