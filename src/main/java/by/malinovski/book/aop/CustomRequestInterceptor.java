package by.malinovski.book.aop;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

@Component
public class CustomRequestInterceptor extends HandlerInterceptorAdapter {

  private final Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) {

    long startTime = Instant.now().toEpochMilli();
    logger.info(
        "Request URL::" + request.getRequestURL().toString() + ":: Start Time=" + Instant.now());
    request.setAttribute("startTime", startTime);
    return true;
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    long startTime = (Long) request.getAttribute("startTime");

    logger.info(
        "Request URL::"
            + request.getRequestURL().toString()
            + ":: Time Taken="
            + (Instant.now().toEpochMilli() - startTime));
  }
}
