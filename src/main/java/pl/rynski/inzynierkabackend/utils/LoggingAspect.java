package pl.rynski.inzynierkabackend.utils;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Log4j2
@Component
public class LoggingAspect {
    //zostawiam tymczasowo oba, calkiem przydatne w sumie
    //method will execute after each call of any public method from service package
    @After("execution(public * pl.rynski.inzynierkabackend.service.*.*(..))")
    public void logMethod(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature().getName() + " method invoked");
    }

    @AfterThrowing(pointcut = "execution(public * pl.rynski.inzynierkabackend.service.*.*(..))", throwing = "error")
    public void logException(JoinPoint joinPoint, Throwable error) {
        log.info(joinPoint.getSignature().getName() + " invoked exception. Exception type: " + error);
    }
}
