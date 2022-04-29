package homework28.service.attachment;

import homework28.model.Image;

import java.util.List;

public interface ImageService {

    void save(Image image);

    Image getById(Long id);

    List<Image> getAll();

    void deleteById(Long id);

}
