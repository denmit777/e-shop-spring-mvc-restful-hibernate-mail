package homework28.service.impl;

import homework28.dao.UserDAO;
import homework28.model.User;
import homework28.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User save(User user) {
        userDAO.save(user);

        return user;
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User update(Long id, User user) {
        user.setId(id);

        userDAO.save(user);

        return user;
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
