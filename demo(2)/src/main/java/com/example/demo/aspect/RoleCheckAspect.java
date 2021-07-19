package com.example.demo.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@SuppressWarnings({"unused"})
@Log4j2
public class RoleCheckAspect {

    @Pointcut("execution(public * com.example.demo.*.controller.*(..))")
    public void annotationPointcut() {

    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        // 此处进入到方法前  可以实现一些业务逻辑
        System.out.println("ssss");
    }

    @Around("annotationPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return null;
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint
     */
    @AfterReturning("annotationPointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
    }

    public void check(long processInstanceId) {

    }

}
