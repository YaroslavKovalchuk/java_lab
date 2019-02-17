package third_task;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        IntStream numbersOne = Arrays.stream(randOneWay());
        IntStream numbersTwo = Arrays.stream(randomTwoWay());

        numbersOne.forEach(System.out::println);
        System.out.println();

        // count average
        double average = numbersOne.average().getAsDouble();
        System.out.println("count average : " + average);

        // max
        System.out.println("max : " + numbersOne.max().getAsInt());

        // min
        System.out.println("min : " + numbersOne.min().getAsInt());

        // sum
        System.out.println("sum : " +  numbersOne.sum());

        // sum with reduce
        System.out.println("sum : " + numbersOne.reduce((x,y) -> x+y));

        // count number that are bigger the average
        System.out.println("count number that are bigger the average" + numbersOne.filter((s) -> s > average).count());

    }

    public static int[] randOneWay(){
        return new Random().ints().limit(10).toArray();
    }

    public static int[] randomTwoWay(){
        return new Random().ints(10,-10,10).toArray();
    }


}
