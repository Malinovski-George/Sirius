package by.malinovski.book.util.convertors;

import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.model.Photos.FlatPhoto;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
public class PhotoConvertor {
  public Set<FlatPhoto> getPhotosFromDto(SimpleFlatDto simpleFlatDto, Flat flat)
      throws IOException {
    Set<FlatPhoto> res = new HashSet<>();

    for (MultipartFile uploadedFile : simpleFlatDto.getMultipartFiles()) {
      FlatPhoto flatPhoto = new FlatPhoto();

      flatPhoto.setImage(uploadedFile.getBytes());
      flatPhoto.setFlat(flat);
      res.add(flatPhoto);
    }
    return res;
  }
}
