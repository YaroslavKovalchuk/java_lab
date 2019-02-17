package first_task;

public class Main {

    public static void main(String[] args) {

        NumberOperation max = (a,b,c) -> (a > b && a > c) ? a : (b > a && b > c) ? b : c ;
        NumberOperation avarage = (a,b,c) -> (a + b + c) / 3;

        System.out.println(max.function(9,8,7));
        System.out.println(avarage.function(9,8,8));

    }

}
