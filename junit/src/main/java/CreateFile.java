import java.io.File;
import java.io.IOException;

public class CreateFile {

    private File file;

    public void create(){
        try {
             file = new File("D:\\newfile.txt");
            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean created(){
       return  file.exists();
    }
}
