
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    public static final String TEST_FIRST_NAME = "John";
    public static final String TEST_LAST_NAME = "Due";

    static Person personOne;
    static Person personTwo;
    static Adress adressnMock;

    @BeforeAll
    static void beforeAllTests() {
        adressnMock = mock(Adress.class);
        personOne = new Person(TEST_FIRST_NAME,TEST_LAST_NAME,adressnMock);
        personTwo = new Person(TEST_FIRST_NAME,TEST_LAST_NAME,adressnMock);
    }

    @Test
    void getName() {
        assertEquals("John",personOne.getName());
    }

    @Test
    void getSurname() {
        assertEquals("Due",personOne.getSurname());
    }

    @Test
    void equalsTest(){
        assertTrue(personOne.equals(personTwo));
    }
}