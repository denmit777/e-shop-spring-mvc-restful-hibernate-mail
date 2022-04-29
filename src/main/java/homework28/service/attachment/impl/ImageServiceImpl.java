package homework28.service.attachment.impl;

import homework28.dao.ImageDAO;
import homework28.model.Image;
import homework28.service.attachment.ImageService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageDAO imageDAO;

    public ImageServiceImpl(ImageDAO imageDAO) {
        this.imageDAO = imageDAO;
    }

    @Override
    @Transactional
    public void save(@NonNull Image image) {
        imageDAO.save(image);
    }

    @Override
    @Transactional
    public Image getById(Long id) {
        return imageDAO.getById(id);
    }

    @Override
    @Transactional
    public List<Image> getAll() {
        return imageDAO.getAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        imageDAO.deleteById(id);
    }
}
