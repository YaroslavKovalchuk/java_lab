package second_task;

public class RunCommand implements Command {

    Dog dog;

    public RunCommand(Dog dog){
        this.dog = dog;
    }

    @Override
    public void execute(String times) {
        dog.run(times);
    }
}
