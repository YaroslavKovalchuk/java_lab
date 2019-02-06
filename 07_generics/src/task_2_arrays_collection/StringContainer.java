package task_2_arrays_collection;

import java.util.Arrays;

public class StringContainer {

    private String []oldContainer = new String[15];
    private String []newContainer = new String[15];
    private int size;
    private int position = 0;

    public void add(String element){
        if (position == newContainer.length){
            for (int i = 0; i < newContainer.length; i++){
                oldContainer[i] = newContainer[i];
            }
            newContainer = new String[newContainer.length + 15];
            for (int i = 0; i < oldContainer.length; i++){
                newContainer[i] = oldContainer[i];
            }
        }
        newContainer[position] = element;
            position++;
    }

    public String get(int position){
        return newContainer[position];
    }

    public int getSize() {
        size = newContainer.length;
        return size;
    }

    @Override
    public String toString() {
        return "StringContainer{" +
                "newContainer=" + Arrays.toString(newContainer) +
                '}';
    }
}
