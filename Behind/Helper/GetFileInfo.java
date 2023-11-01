import java.io.File;
public class GetFileInfo {
    public static void main(String[] args) {
        String a = "D:\\2nd_Year_project\\TestFile.txt";
        File f = new File(a);
        if (f.exists()) {
            System.out.println("File Name :"+f.getName());
            System.out.println("File Path :"+f.getAbsolutePath());
            System.out.println("File Readable :"+f.canRead());
            System.out.println("File Writable :"+f.canWrite());
            System.out.println("File Length :"+f.length());
        }
        else {
            System.out.println("File doesn't exist");
        }
    }
}
