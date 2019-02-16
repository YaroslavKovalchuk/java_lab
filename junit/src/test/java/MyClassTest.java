import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {

    MyClass tester;

    @BeforeEach
    void setUp() {
        tester  = new MyClass();
    }

    @Test
    void regcatngleArea() {
        assertEquals(0, tester.regcatngleArea(0.0,5.2),"must be 0");
        assertEquals(0,tester.regcatngleArea(5.2,0.0),"must be 0");
        assertEquals(30,tester.regcatngleArea(6.0,5.0),"must be 30.0");
    }

    @Test
    void rectanglePerimeter() {
        assertEquals(0, tester.rectanglePerimeter(0.0,5.2),"must be 0.0");
        assertEquals(0,tester.rectanglePerimeter(5.2,0.0),"must be 0.0");
        assertEquals(22,tester.rectanglePerimeter(6.0,5.0),"must be 22.0");
    }
}