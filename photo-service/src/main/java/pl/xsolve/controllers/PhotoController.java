package pl.xsolve.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.xsolve.model.PhotoGenerateDTO;
import pl.xsolve.services.PhotoService;

@RestController
public class PhotoController {

    protected final PhotoService photoService;

    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String generatePhotoUrl(@RequestBody PhotoGenerateDTO photoGenerateDTO) {
        return photoService.generatePhotoUrl(photoGenerateDTO);
    }

}
