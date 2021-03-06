package com.ljq.framework.codec;

import com.ljq.framework.fields.FieldType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
    int index() default -1;

    FieldType type() default FieldType.INT8;

    int length() default -1;
}
