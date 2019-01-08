package by.malinovski.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(SQLException.class)
  public String handleSQLException(HttpServletRequest request, Exception ex) {
    logger.info("SQLException Occured:: URL=" + request.getRequestURL());
    return "database_error";
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
  @ExceptionHandler(IOException.class)
  public ModelAndView handleIOException(HttpServletRequest request, Exception ex) {
    logger.error("IOException handler executed");

    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("exception", ex);
    modelAndView.addObject("url", request.getRequestURL());
    modelAndView.setViewName("service/error");
    return modelAndView;
  }
}
