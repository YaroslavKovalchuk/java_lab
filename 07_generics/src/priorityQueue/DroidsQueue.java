package priorityQueue;

import java.util.Arrays;
import java.util.Comparator;

public class DroidsQueue<T extends Droid> {

    private T [] oldBasket;
    private T [] newBasket;
    private T element;
    private int size = 1;
    private Integer priority ;
    private Comparator comparator;

    public DroidsQueue(){
        priority = new Integer(-1);
    }

    public DroidsQueue(Comparator<? super T> comparator){
       this.comparator = comparator;
       priority = new Integer(0);;
    }

    public void add(T t){

        if (newBasket == null) {

            oldBasket = (T[]) new Droid[1];

        } else {
            size = newBasket.length + 1;

            oldBasket = newBasket.clone();

        }

        // without comparator - natural ordering

        newBasket = Arrays.copyOf(oldBasket, size);

        newBasket[newBasket.length - 1] = t;

        // orders its elements according to the specified comparator
        if (priority.equals(0)){

            for (int i = 0 ; i < newBasket.length-1; i++){

                if (priority < comparator.compare(newBasket[i],newBasket[i+1])){

                            T var = newBasket[i];

                            newBasket[i] = newBasket[i+1];

                            newBasket[i+1] = var;

                }
            }
        }
    }


    public T get(int position){
        return   element = newBasket[position];
    }

    public int getSize() {
        return size;
    }
}
