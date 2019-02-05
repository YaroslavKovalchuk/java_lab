package task_1_shipWithDroids;

import java.util.Arrays;

public class Ship<T extends Droid> {

    private T element;
    private T[] basket;
    private T[] oldBasket;
    private int size = 1 ;

    public void put(T t){
        if (basket == null){
            oldBasket  = (T[]) new Droid[1];
        }else {size = basket.length + 1;
                oldBasket = basket.clone();
        }
        basket = Arrays.copyOf(oldBasket,size);
        basket[basket.length-1] = t;
    }

    public T get(int position){
      return   element = basket[position];
    }

}
