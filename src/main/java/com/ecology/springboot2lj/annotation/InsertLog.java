package com.ecology.springboot2lj.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Documented
public @interface InsertLog {
    String logStr() default "日志操作";
}
