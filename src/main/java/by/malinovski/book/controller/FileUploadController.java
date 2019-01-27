package by.malinovski.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class FileUploadController {

  @RequestMapping(
    path = {"/upload"},
    method = RequestMethod.POST
  )
  public void upload(MultipartHttpServletRequest request, HttpServletResponse response)
      throws IOException {

    // Getting uploaded files from the request object
    Map<String, MultipartFile> fileMap = request.getFileMap();

    // Maintain a list to send back the files info. to the client side
    List uploadedFiles = new ArrayList();

    // Iterate through the map
    for (MultipartFile multipartFile : fileMap.values()) {

      // Save the file to local disk

    }
  }
}
