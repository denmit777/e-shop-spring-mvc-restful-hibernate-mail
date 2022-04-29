package homework28.dao;

import homework28.model.User;

import java.util.List;

public interface UserDAO {

    void save(User user);

    User getById(Long id);

    User getByLogin(String login);

    List<User> getAll();
    
    void deleteById(Long id);    
}

