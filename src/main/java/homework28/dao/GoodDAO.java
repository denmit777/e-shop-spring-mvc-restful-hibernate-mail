package homework28.dao;

import homework28.model.Good;

import java.util.List;

public interface GoodDAO {

    void save(Good good);

    Good getById(Long id);

    List<Good> getAll();

    void deleteById(Long id);
}
