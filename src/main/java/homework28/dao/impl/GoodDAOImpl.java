package homework28.dao.impl;

import homework28.dao.GoodDAO;
import homework28.model.Good;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodDAOImpl implements GoodDAO {

    private static final String QUERY_SELECT_FROM_GOOD = "from Good";

    private final SessionFactory sessionFactory;

    public GoodDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Good good) {
        getCurrentSession().save(good);
    }

    @Override
    public Good getById(Long id) {
        return getCurrentSession().get(Good.class, id);
    }

    @Override
    public List<Good> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_GOOD).list();
    }

    @Override
    public void deleteById(Long id) {
        final Good good = getById(id);

        getCurrentSession().delete(good);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
