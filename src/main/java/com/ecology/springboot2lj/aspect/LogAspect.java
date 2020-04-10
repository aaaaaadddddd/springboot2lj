package com.ecology.springboot2lj.aspect;

import com.ecology.springboot2lj.annotation.InsertLog;
import com.ecology.springboot2lj.utiles.AnnotationUtils;
import org.apache.ibatis.javassist.NotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 该切面为：日志记录，
 */
@Component
@Aspect
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.ecology.springboot2lj.controller..*(..))")
    private void pointcut() {
    }

    @After(value = "pointcut()")
    public void After(JoinPoint joinPoint) throws NotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String logStr = AnnotationUtils.get().getAnnotatioinFieldValue(className, methodName, InsertLog.class.getName(), "logStr");
        if (!StringUtils.isEmpty(logStr)) {
            logger.info("获取日志：" + logStr);
            // 数据库记录日志操作...
        }
    }
}
