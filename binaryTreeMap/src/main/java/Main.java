public class Main {

    public static void main(String[] args) {

        Tree<String> trees = new Tree<>();
        trees.put(5,"HELLO");
        trees.put(10,"World");
        trees.put(2,"bay");
        trees.put(11,"HELLO1");
        trees.put(13,"World1");
        trees.put(6,"World2");
        trees.put(9,"bay1");
        trees.put(12,"World3");
        trees.put(4,"bay3");
        trees.put(1,"HELLO3");
        trees.put(15,"World4");
        trees.put(14,"World4");
        trees.put(7,"World5");

       trees.remove(10);

        //trees.getParent(9).display();

      //  System.out.println(trees.containsValue("der"));
      //   trees.get(10).getRightChild().display();
      //    System.out.println(trees.containsKey(8));
    }


}
