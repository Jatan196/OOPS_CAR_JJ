import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class test {
    public static void main(String[] args) {
        String a = "D:\\2nd_Year_project\\Test.txt";
        String b = "D:\\2nd_Year_project\\another.txt";
        try {
            FileReader fr = new FileReader(a);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(b);
            // FileWriter fw = new FileWriter(a);
            String line=null;
            while ((line = br.readLine())!=null) {
                System.out.println(line);
                fw.write(line+"\n");
            }
            // line = br.readLine();
            System.out.println(line);
            
            // FileWriter fw = new FileWriter(a);
            
            br.close();
            fw.close();
        }
        catch(Exception e) {
            System.out.println("Excepteion occured");
        }
        
    }
}