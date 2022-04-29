package homework28.dao.impl;

import homework28.dao.ImageDAO;
import homework28.model.Image;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDAOImpl implements ImageDAO {

    private static final String QUERY_SELECT_FROM_IMAGE = "from Image";

    private final SessionFactory sessionFactory;

    public ImageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Image image) {
        getCurrentSession().save(image);
    }

    @Override
    public Image getById(Long id) {
        return getCurrentSession().get(Image.class, id);
    }

    @Override
    public List<Image> getAll() {
        return getCurrentSession().createQuery(QUERY_SELECT_FROM_IMAGE).list();
    }

    @Override
    public void deleteById(Long id) {
        final Image image = getById(id);

        getCurrentSession().delete(image);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
