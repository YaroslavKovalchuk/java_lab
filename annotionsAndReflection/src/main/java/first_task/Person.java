package first_task;

public class Person {

    @MyAnnotation(name = "Yaroslav")
    public String name;

    public String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String first(String name){
        return name + " - first ";
    }

    public String second(int number){
        return number + " - second ";
    }

    public String third(double number){
        return number + " - third ";
    }

    public String myMethod(String a, int ... args){
        return a + " - " + args + " = fourth";
    }
}
