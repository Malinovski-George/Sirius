package by.malinovski.book.controller;

import by.malinovski.book.dao.impl.PhotoDao;
import by.malinovski.book.dto.SimpleFlatDto;
import by.malinovski.book.model.Photos.FlatPhoto;
import by.malinovski.book.model.User;
import by.malinovski.book.service.IFlatService;
import by.malinovski.book.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.Principal;

@Controller
public class FlatController {

  @Autowired IFlatService flatService;

  @Autowired UserService userService;

  @Autowired PhotoDao photoDao;

  // simple registration
  @RequestMapping(
      path = {"/registrationForm"},
      method = RequestMethod.GET)
  public ModelAndView newFlatRegistrationFormGet() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("registrationForm");
    modelAndView.addObject("simpleFlatDto", new SimpleFlatDto());
    return modelAndView;
  }

  @RequestMapping(
      path = {"/registrationForm"},
      method = RequestMethod.POST)
  public String registrationFormPost1(
      @Valid SimpleFlatDto simpleFlatDto, BindingResult result, Principal principal)
      throws IOException {

    if (result.hasErrors()) {
      return "registrationForm";
    }

    User user = userService.getUserByEmail(principal.getName());
    flatService.saveNewFlat(simpleFlatDto, user);

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("home");
    modelAndView.setStatus(HttpStatus.OK);
    return "redirect:/";
  }

  @RequestMapping(
    path = {"/image/{imgid}"},
    method = RequestMethod.GET
  )
  public void registrationFormPost1(
      HttpServletRequest request,
      @PathVariable(value = "imgid") String imgid,
      HttpServletResponse response)
      throws IOException {

    response.reset();
    String contentType = "img/png";
    response.setContentType(contentType);
    OutputStream out = response.getOutputStream();

    if (!imgid.equals("-1")) {
      FlatPhoto photo = photoDao.getPhotoById(imgid);
      response.setContentLength((int) photo.getImage().length);
      out.write(photo.getImage());
    } else {
      BufferedImage originalImage =
          ImageIO.read(getClass().getResource("/static/images/NoPhoto.png"));
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(originalImage, "png", baos);
      baos.flush();
      byte[] imageInByte = baos.toByteArray();
      baos.close();
      response.setContentLength(imageInByte.length);
      out.write(imageInByte);
    }
    out.flush();
    out.close();
    response.setStatus(HttpServletResponse.SC_OK);
  }

  // TODO GM: RequestMethod.GET => RequestMethod.DELETE
  @RequestMapping(
      path = {"/flats/{id}"},
      method = RequestMethod.GET)
  public String deleteFlat(Principal principal, @PathVariable(value = "id") String id)
      throws IOException {
    User user = userService.getUserByEmail(principal.getName());
    if (flatService.canDelete(user, Integer.valueOf(id))) {
      flatService.delete(Integer.valueOf(id));
    }
    return "redirect:/";
  }

  @RequestMapping(
      path = {"/user/flats/{id}"},
      method = RequestMethod.GET)
  public ModelAndView updateFlat(Principal principal, @PathVariable(value = "id") String id)
      throws IOException {

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("updateForm");

    SimpleFlatDto flatDto = flatService.getSimpleFlatDtoById(Integer.valueOf(id));
    modelAndView.addObject("simpleFlatDto", flatDto);
    return modelAndView;
  }

  @RequestMapping(
      path = {"/user/flats/{id}"},
      method = RequestMethod.DELETE)
  public String deleteUserFlat(Principal principal, @PathVariable(value = "id") String id)
      throws IOException {
    User user = userService.getUserByEmail(principal.getName());
    if (flatService.canDelete(user, Integer.valueOf(id))) {
      flatService.delete(Integer.valueOf(id));
    }
    return "redirect:/user-page";
  }

  @RequestMapping(
      path = {"/user/flats/{id}"},
      method = RequestMethod.POST)
  public String updateUserFlat(
      @Valid SimpleFlatDto simpleFlatDto,
      BindingResult result,
      @PathVariable(value = "id") String id)
      throws IOException {

    if (result.hasErrors()) {
      return "registrationForm";
    }

    flatService.updateFlat(simpleFlatDto, Integer.valueOf(id));

    return "redirect:/user-page";
  }
}
