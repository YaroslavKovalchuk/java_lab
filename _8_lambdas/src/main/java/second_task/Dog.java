package second_task;

public class Dog {

    public void run(String howManyTimes){
        repeat(howManyTimes,"running");
    }

    public void sit(String howManyTimes){
       repeat(howManyTimes,"sitting");
    }

    public void lie(String howManyTimes){
        repeat(howManyTimes,"lying");
    }

    public void bark(String howManyTimes){
        repeat(howManyTimes,"barking");
    }

    private void repeat(String howManyTimes,String what){

        int amount = Integer.valueOf(howManyTimes);

        for (int i = 0; i < amount; i++) {
            System.out.println(what);
        }
    }
}
