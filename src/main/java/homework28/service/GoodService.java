package homework28.service;

import homework28.model.Good;

import java.util.List;

public interface GoodService {

    Good save(Good good);

    Good getById(Long id);

    List<Good> getAll();

    Good update(Long id, Good good);

    void deleteById(Long id);
}
