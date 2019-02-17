package first_task;

import java.lang.annotation.*;

@Documented
@Target(value =  ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyMethodAnnotation {
    String name();
}
