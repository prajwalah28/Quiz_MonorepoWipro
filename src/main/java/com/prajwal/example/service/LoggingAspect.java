package com.prajwal.example.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {


    @Before("execution(* com.prajwal.example.service.QuestionService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("📌 Starting method: " + joinPoint.getSignature().getName());
        System.out.println("   Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.prajwal.example.service.QuestionService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("✅ Method completed: " + joinPoint.getSignature().getName());
        System.out.println("   Returned: " + result);
    }


    @Around("execution(* com.prajwal.example.service.QuestionService.*(..))")
    public Object measureExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("⏱ Execution time of " + pjp.getSignature().getName() + ": " + (end - start) + "ms");
        return result;
    }
}
