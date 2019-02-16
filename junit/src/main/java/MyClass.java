public class MyClass {

   protected static final int NUMBER_OF_RECTANGLE_EDGES = 4;

   public double regcatngleArea(double a, double b){
       return a*b;
   }

   public double rectanglePerimeter (double a, double b){
       if (a == 0.0) return 0.0;
       if (b == 0.0) return 0.0;
       return NUMBER_OF_RECTANGLE_EDGES/2 * (a + b);
   }

}
