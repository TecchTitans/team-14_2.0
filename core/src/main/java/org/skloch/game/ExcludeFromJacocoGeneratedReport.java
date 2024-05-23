package main.java.org.skloch.game;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
public @interface ExcludeFromJacocoGeneratedReport {}
