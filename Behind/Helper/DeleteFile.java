import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        String s = "D:\\2nd_Year_project\\TestFile.txt";
        File f = new File(s);
        if(f.exists()) {
            
            System.out.println("File Deleted : "+f.delete());
        }
        else {
            System.out.println("File doesn't exist");
        }
    }
}