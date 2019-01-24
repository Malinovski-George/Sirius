package by.malinovski.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Controller
@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(SQLException.class)
  public String handleSQLException(HttpServletRequest request, Exception ex) {
    logger.info("SQLException Occured:: URL=" + request.getRequestURL());
    return "error";
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data integrity violation") // 404
  @ExceptionHandler(ResponseStatusException.class)
  public ModelAndView notFound(HttpServletRequest request, Exception ex) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", ex);
    modelAndView.addObject("url", request.getRequestURL());
    modelAndView.setViewName("error");
    return modelAndView;
  }
}
