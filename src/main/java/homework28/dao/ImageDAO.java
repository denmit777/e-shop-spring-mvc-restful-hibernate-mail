package homework28.dao;

import homework28.model.Image;

import java.util.List;

public interface ImageDAO {

    void save(Image image);

    Image getById(Long id);

    List<Image> getAll();

    void deleteById(Long id);



}
