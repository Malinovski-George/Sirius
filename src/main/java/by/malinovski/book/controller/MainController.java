package by.malinovski.book.controller;


import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.User;
import by.malinovski.book.service.impl.FlatService;
import by.malinovski.book.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    FlatService flatService;


    @Autowired
    UserService userService;



    @RequestMapping(path = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView showHome() {

        List<SimpleFlatDto> allFlats = flatService.getAllSimpleFlatsDto();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("appName", "asdasd");
        modelAndView.addObject("flats", allFlats);
        modelAndView.addObject("fields", allFlats.size());
        return modelAndView;
    }
/*
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

     *//*   UploadedFile dataFile = uploadService.getFile(fileId);

        File file = new File(dataFile.getLocation(), dataFile.getName());

        try {
            response.setContentType(dataFile.getType());
            response.setHeader("Content-disposition", "attachment; filename=\""
                    + dataFile.getName() + "\"");

            FileCopyUtils.copy(FileUtils.readFileToByteArray(file),
                    response.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }*//*
    }*/

    @RequestMapping(value = "/accessDeniedPage", method = RequestMethod.GET)
    public String AccessDinied() {
        return "/accessDeniedPage";
    }


    @RequestMapping(value = "/user-page", method = RequestMethod.GET)
    public ModelAndView UserPage(Principal principal) {


        User user = userService.getUserByEmail(principal.getName());
        List<SimpleFlatDto> flats = flatService.getSimpleFlatDtoByUser(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user-page");
        modelAndView.addObject("flats", flats);

        return modelAndView;
    }
}
