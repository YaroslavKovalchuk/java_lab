import task_1_shipWithDroids.ConcreteDroid;
import task_1_shipWithDroids.Droid;
import task_1_shipWithDroids.Ship;
import priorityQueue.Droid;
import priorityQueue.DroidsQueue;


public class Main {

    public static void main(String[] args) {
        Droid ivan = new ConcreteDroid();
        ivan.setName("ivan");

        Droid petro = new ConcreteDroid();
        petro.setName("petro");
        
        Droid andriy = new Droid();
        andriy.setName("andriy");

        Droid denys = new Droid();
        denys.setName("denys");

        Ship<Droid> ship = new Ship<>();
        ship.put(ivan);
        ship.put(petro);
        System.out.println(ship.get(0).getName());
        System.out.println(ship.get(2).getName());
    

        DroidsQueue<Droid> droidsQueue = new DroidsQueue<>(new Droid());
        droidsQueue.add(ivan);
        droidsQueue.add(andriy);
        droidsQueue.add(denys);

        for ( int i = 0; i < droidsQueue.getSize(); i ++){
            System.out.println(droidsQueue.get(i));
        }
    }
}
