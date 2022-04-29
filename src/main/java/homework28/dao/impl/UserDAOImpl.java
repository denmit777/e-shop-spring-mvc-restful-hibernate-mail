package homework28.dao.impl;

import homework28.dao.UserDAO;
import homework28.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String QUERY_SELECT_FROM_USER = "from User";
    private static final String QUERY_SELECT_FROM_USER_BY_LOGIN = "from User u where u.login = :login";

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(User user) {
        getCurrentSession().save(user);
    }

    @Override
    public User getById(Long id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public User getByLogin(String login) {
        return (User) getCurrentSession().createQuery(QUERY_SELECT_FROM_USER_BY_LOGIN)
                .setParameter("login", login).uniqueResult();
    }

    @Override
    public List<User> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_USER).list();
    }

    @Override
    public void deleteById(Long id) {
        final User user = getById(id);

        getCurrentSession().delete(user);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
