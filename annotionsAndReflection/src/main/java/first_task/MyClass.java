package first_task;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClass {

    public static void main(String[] args) {

        Person person = new Person("Yaroslav","Kovalchuk");

        Class<?> personClass = person.getClass();

        Field[] fields = personClass.getFields();

        for (int i = 0; i < fields.length; i++) {
            if (fields[i].isAnnotationPresent(MyAnnotation.class)) {
                System.out.println(fields[i].getName());
                MyAnnotation myAnnotation = fields[i].getAnnotation(MyAnnotation.class);
                System.out.println(myAnnotation.name());
            }
        }

        Method method = null;
        try {

            method = personClass.getDeclaredMethod("first", String.class);
            System.out.println(method.invoke(person,person.name));

            method = personClass.getDeclaredMethod("second", int.class);
            System.out.println(method.invoke(person,22));

            method = personClass.getDeclaredMethod("third", double.class);
            System.out.println(method.invoke(person,22.2));

            method = personClass.getDeclaredMethod("myMethod", String.class, int[].class);
            System.out.println(method.invoke(person,person.lastName, new int[]{11,22}));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
