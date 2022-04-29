package homework28.controller.rest;

import homework28.model.Image;
import homework28.service.attachment.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "orders/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<Void> uploadImage(@RequestParam MultipartFile file) throws IOException {
        Image image = new Image();

        image.setName(file.getName());
        image.setPhoto(file.getBytes());

        imageService.save(image);
        return ResponseEntity.created(URI.create(image.getName())).build();
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok(imageService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> downloadImage(@PathVariable("id") Long id) {
        Image image = imageService.getById(id);

        return ResponseEntity.ok(image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable("id") Long id) {
        imageService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
