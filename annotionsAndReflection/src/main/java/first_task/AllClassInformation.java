package first_task;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class AllClassInformation<T> {

    private Class<?> tClass;

    public AllClassInformation(T t){
       tClass = t.getClass();
    }

    public String getPackageName(){
        return tClass.getPackage().getName();
    }

    public String getClassModifier(){
        return  Modifier.toString(tClass.getModifiers());
    }

    public String getSuperClass(){
        return Person.class.getSuperclass().getName();
    }

    public Type[] getAllImplementsInterfaces(){
        return tClass.getGenericInterfaces();
    }

    public Field[] getAllPublicClassFields(){
        return tClass.getFields();
    }

    public Constructor[] getAllPublicConstructor(){
        return tClass.getConstructors();
    }

    public Method[] getAllPublicClassMethod(){
        return tClass.getMethods();
    }

    public Annotation[] getAllClassAnnotation(){
        return tClass.getAnnotations();
    }

    public static void main(String[] args) {

        AllClassInformation<Person> allClassInformation = new AllClassInformation<>(new Person());

        Arrays.stream(allClassInformation.getAllPublicClassMethod())
                .forEach(System.out::println);

        System.out.println(allClassInformation.getPackageName());

    }

}
