package pl.xsolve.services;


import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import pl.xsolve.model.PhotoGenerateDTO;

import java.util.Base64;

@Service
@RefreshScope
public class PhotoService {

    @Value("${overlay_image_width}")
    protected Integer overlayImageWidth;

    protected final Cloudinary cloudinary;

    @Autowired
    public PhotoService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public String generatePhotoUrl(PhotoGenerateDTO photoGenerateDTO) {
        String remoteIconUrl = "fetch:" + getIcon(photoGenerateDTO.getWeatherType());

        String refactoredUrl = cloudinary.url()
                .transformation(new Transformation().overlay(remoteIconUrl)
                        .gravity("faces")
                        .width(overlayImageWidth))
                .type("fetch")
                .imageTag(photoGenerateDTO.getImageUrl());

        String url = refactoredUrl.substring("<img src='".length(), refactoredUrl.length() - "'/>".length());

        return url;
    }

    protected String getIcon(String weatherKind) {
        switch (weatherKind) {
            case "Rain":
                return Base64.getEncoder().encodeToString("http://icons.iconarchive.com/icons/sonya/swarm/256/Rain-icon.png".getBytes());
            case "Clouds":
                return Base64.getEncoder().encodeToString("http://icons.iconseeker.com/ico/weather/cloudy.ico".getBytes());
            case "Sunny":
                return Base64.getEncoder().encodeToString("https://openclipart.org/image/2400px/svg_to_png/176605/1364574715.png".getBytes());
            default:
                return Base64.getEncoder().encodeToString("https://openclipart.org/image/2400px/svg_to_png/176605/1364574715.png".getBytes());
        }
    }
}
