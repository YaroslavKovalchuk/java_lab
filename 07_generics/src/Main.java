import task_1_shipWithDroids.ConcreteDroid;
import task_1_shipWithDroids.Droid;
import task_1_shipWithDroids.Ship;

public class Main {

    public static void main(String[] args) {
        Droid ivan = new ConcreteDroid();
        ivan.setName("ivan");

        Droid petro = new ConcreteDroid();
        petro.setName("petro");

        Ship<Droid> ship = new Ship<>();
        ship.put(ivan);
        ship.put(petro);
        System.out.println(ship.get(0).getName());
        System.out.println(ship.get(2).getName());
    }
}
