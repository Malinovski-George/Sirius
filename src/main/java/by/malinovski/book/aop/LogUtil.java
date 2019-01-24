package by.malinovski.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Aspect
@Profile("production")
public class LogUtil {

  private final Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass());

  @Pointcut("execution(* by.malinovski.book.*.*.*(..))")
  public Object logEventMethod(ProceedingJoinPoint joinPoint) throws Throwable {

    Object retVal = joinPoint.proceed();

    StringBuilder logMessage = new StringBuilder();
    logMessage.append(joinPoint.getTarget().getClass().getName());
    logMessage.append(".");
    logMessage.append(joinPoint.getSignature().getName());
    logMessage.append("(");

    Object[] args = joinPoint.getArgs();
    for (int i = 0; i < args.length; i++) {
      logMessage.append(args[i]).append(",");
    }
    if (args.length > 0) {
      logMessage.deleteCharAt(logMessage.length() - 1);
    }
    logMessage.append(")");
    log.info(logMessage.toString());
    return retVal;
  }

  /*@AfterThrowing
  public void logExceptionMethod(Throwable error) throws Throwable {
      StringBuilder logMessage = new StringBuilder();
      logMessage.append("\n ERROR MESSAGE: ");
      logMessage.append(error.getMessage());

      logMessage.append("\n ERROR STACKTRACE: ");
      for (StackTraceElement str:error.getStackTrace())
      {
          logMessage.append(" ");
          logMessage.append(str);
          logMessage.append("\n");
      }
      log.error(logMessage.toString());
  }*/

  @Before("execution(* by.malinovski.book.*.*.*(..))")
  public void before(JoinPoint joinPoint) {
    // Advice
    log.info("!!! Check for user access ");
    log.info("!!! Allowed execution for {}", joinPoint);
  }
}
