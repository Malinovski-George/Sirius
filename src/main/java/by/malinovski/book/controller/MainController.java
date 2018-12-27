package by.malinovski.book.controller;


import by.malinovski.book.dto.RegistrationFormDto;
import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Flat;
import by.malinovski.book.service.impl.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

                @Autowired
                FlatService flatService;

   /* @RequestMapping(path = { "/", "/home" }, method = RequestMethod.GET)
    public String showHome() {
        return "home";
    }*/


                @RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
                public ModelAndView showHome() {
//    public String showHome() {

//                    List<Flat> list2 =        flatService.getAllFlats();
/*

                    List<Flat> list = new LinkedList<>();
                    list.add(new Flat());
                    list.add(new Flat());
                    list.add(new Flat());
                    list.add(new Flat());
                    list.add(new Flat());
            list.add(new Flat());
*/
                    List<SimpleFlatDto> allFlats = flatService.getAllFlats();

                    ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("home");
            modelAndView.addObject("appName", "asdasd");
            modelAndView.addObject("flats", allFlats);
            modelAndView.addObject("fields", allFlats.size());
            return modelAndView;
//        return "home";
    }



   /* @RequestMapping(path = {"/userRegistration"}, method = RequestMethod.GET)
    public String userRegistrationFormPost(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {

        model.addAttribute("user", registrationFormDto);
        return "userRegistration";
    }
*/
  /* @RequestMapping(path = {"/registrationForm"}, method = RequestMethod.POST)
   public String registrationFormPost(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {


       model.addAttribute("registrationFormDto", registrationFormDto);
        return "done";
    }*/

//    @RequestMapping(path = {"/userRegistration"}, method = RequestMethod.GET)
//    public String userRegistrationFormPost(@ModelAttribute RegistrationFormDto registrationFormDto, Model model) {
//
//        model.addAttribute("user", registrationFormDto);
//        return "userRegistration";
//    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    List upload(MultipartHttpServletRequest request,
                HttpServletResponse response) throws IOException {

        // Getting uploaded files from the request object
        Map<String, MultipartFile> fileMap = request.getFileMap();

        // Maintain a list to send back the files info. to the client side
        List uploadedFiles = new ArrayList();

        // Iterate through the map
        for (MultipartFile multipartFile : fileMap.values()) {
            System.out.println("              asdasd                ");
            // Save the file to local disk
//            saveFileToLocalDisk(multipartFile);

//            UploadedFile fileInfo = getUploadedFileInfo(multipartFile);

            // Save the file info to database
//            fileInfo = saveFileToDatabase(fileInfo);

            // adding the file info to the list
//            uploadedFiles.add(fileInfo);
        }

        return uploadedFiles;
    }

    @RequestMapping(value = {"/list"})
    public String listBooks(Map<String, Object> map) {

//        map.put("fileList", uploadService.listFiles());

        // will be resolved to /views/listFiles.jsp
        return "/listFiles";
    }

    @RequestMapping(value = "/get/{fileId}", method = RequestMethod.GET)
    public void getFile(HttpServletResponse response, @PathVariable Long fileId) {

     /*   UploadedFile dataFile = uploadService.getFile(fileId);

        File file = new File(dataFile.getLocation(), dataFile.getName());

        try {
            response.setContentType(dataFile.getType());
            response.setHeader("Content-disposition", "attachment; filename=\""
                    + dataFile.getName() + "\"");

            FileCopyUtils.copy(FileUtils.readFileToByteArray(file),
                    response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }


}
