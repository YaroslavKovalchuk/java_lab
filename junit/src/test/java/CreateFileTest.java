import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreateFileTest {

    @Test
    void create() {
        CreateFile createFile = new CreateFile();
        createFile.create();
        assertTrue(createFile.created());
    }
}