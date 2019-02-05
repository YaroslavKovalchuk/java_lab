package priorityQueue;

import java.util.Comparator;

public class Droid implements Comparator<Droid> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Droid o1, Droid o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                '}';
    }
}
