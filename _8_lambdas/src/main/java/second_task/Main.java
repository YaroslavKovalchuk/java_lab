package second_task;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        // implements via object of command class
        Command run = new RunCommand(dog);

        // implements via anonymous class
        Command sit = new Command() {
            @Override
            public void execute(String times) {
                dog.sit(times);
            }
        };

        // implements via lambda
        Command lie = (t) -> {dog.lie(t);};

        // implements via method reference
        Command bark = dog::bark;

        while(true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().trim();
            String [] nameAndTimes = command.split(" ");
            String commandName = nameAndTimes[0];
            String times = nameAndTimes[1];
            switch (commandName) {
                case "run":
                    run.execute(times);
                    break;
                case "sit":
                    sit.execute(times);
                    break;
                case "lie":
                    lie.execute(times);
                    break;
                case "bark":
                    bark.execute(times);
                    break;
            }
        }

    }

}
