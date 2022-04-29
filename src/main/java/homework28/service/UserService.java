package homework28.service;

import homework28.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User getById(Long id);

    List<User> getAll();

    User update(Long id, User user);

    void deleteById(Long id);
}
