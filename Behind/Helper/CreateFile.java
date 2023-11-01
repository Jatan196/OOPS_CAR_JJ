import java.io.File;
import java.io.IOException;
public class CreateFile {
    public static void main(String[] args) {
        String a = "D:\\2nd_Year_project\\TestFile.txt";
        File file1 = new File(a);
        try {
            if(file1.createNewFile()) {
                System.out.println("Created");
            }

            else {
                System.out.println("Exists");
            }
        }

        catch (IOException i) {
            System.out.println("Error");
        }
    }
}
