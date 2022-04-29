package homework28.dao.impl;

import homework28.dao.OrderDAO;
import homework28.model.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    private static final String QUERY_SELECT_FROM_ORDER = "from Order";
    private static final String QUERY_SELECT_FROM_ORDER_BY_USER_ID = "from Order o where o.userId = :userId";

    private final SessionFactory sessionFactory;

    public OrderDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Order order) {
        getCurrentSession().save(order);
    }

    @Override
    public Order getById(Long id) {
        return getCurrentSession().get(Order.class, id);
    }

    @Override
    public Order getByUserId(Long userId) {
        return (Order) getCurrentSession().createQuery(QUERY_SELECT_FROM_ORDER_BY_USER_ID)
                .setParameter("userId", userId).uniqueResult();
    }

    @Override
    public List<Order> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_ORDER).list();
    }

    @Override
    public void deleteById(Long id) {
        final Order order = getById(id);

        getCurrentSession().delete(order);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
