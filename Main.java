import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import Package.Worker;
import Package.Engineer;
import Package.Supervisor;
import Package.Manager;




public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to JATANJAY CARS Pvt. Ltd.\n");
        System.out.println("If you are a Customer : Press 1");
        System.out.println("If you are an Employee : Press 2\n");
        int type = sc.nextInt();
        switch (type) {
            case 1:
                System.out.println("\nNot created yet\n");
                break;
            case 2 : 
                System.out.print("\nKindly enter your id : ");
                String e_id = sc.next();
                int mainFlag = 0;
                try {
                String a = "Database\\Manage.txt";
                String b = "Database\\Test.txt";
                FileReader fr = new FileReader(a);
                BufferedReader br = new BufferedReader(fr);
                String line = null,newline = null;
                
                while ((line = br.readLine()) != null) {
                    if (line.equals(e_id)) {
                        mainFlag = 1;
                        line = br.readLine();
                        System.out.print("Enter password : ");
                            String e_pass = sc.next();
                            if (line.equals(e_pass)) {
                                System.out.println("Password is not correct\n");
                                return;
                            }

                            System.out.println("\nAuthentication Completed");

                            Manager m = new Manager(e_id, e_pass, line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), 
                            line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), (line=br.readLine()),
                            (line=br.readLine()), (line=br.readLine()), line=br.readLine(), (line=br.readLine()));
                            
                            boolean flag = true;
                            while(flag == true) {
                            System.out.println("\nPlease specify the action you want to perform");
                            System.out.println("1 : View your information");
                            System.out.println("2 : Mark Today's Attendance");
                            System.out.println("3 : View present month's attendance");
                            System.out.println("4 : Apply for leave");
                            System.out.println("5 : View salary for previous month");
                            System.out.println("6 : Get present month target details");
                            System.out.println("7 : Update your information");
                            System.out.println("8 : Change password");
                            System.out.println("9 : Apply for resignation");
                            System.out.println("0 : Exit\n");
                
                            int work = sc.nextInt();
                            switch (work) {
                                case 1 :
                                    System.out.println();
                                    m.showDetails();
                                    break;
                                case 2 : 
                                    System.out.println();
                                    m.markAttendance();
                                    break;
                                case 3 : 
                                    System.out.println();
                                    m.showAttendance();
                                    break;
                                case 4 : 
                                    System.out.println();
                                    m.getLeaves();
                                    break;
                                case 5 : 
                                    System.out.println();
                                    m.printSalary();
                                    break;
                                case 6 : 
                                        System.out.println();
                                    m.getTarget();
                                    break;
                                case 7 : 
                                    System.out.println();
                                    m.updateDetails();
                                    break;
                                case 8 : 
                                    System.out.println();
                                    m.changePassword();
                                    break;
                                case 9 : 
                                    System.out.println();
                                    m.resign();
                                    break;
                                case 0 : 
                                    System.out.println();
                                    flag = false;
                                    break;
                                default: 
                                    System.out.println("Please choose a valid option\n");
                                    break;
                            }
                        }
                    

                    // String b = "D:\\2nd_Year_project\\Test.txt";
                    FileReader fr2 = new FileReader(a);
                    BufferedReader br2 = new BufferedReader(fr2);
                FileWriter fw = new FileWriter(b);
                while ((newline = br2.readLine())!=null) {
                    if (newline.equals(e_id)) {
                        fw.write(newline+"\n");
                        fw.write(m.password+"\n");
                        fw.write(m.name+"\n");
                        fw.write(m.department+"\n");
                        fw.write(m.dob+"\n");
                        fw.write(m.doj+"\n");
                        fw.write(m.address+"\n");
                        fw.write(m.phone+"\n");
                        fw.write(m.email+"\n");
                        fw.write(m.account+"\n");
                        fw.write(m.aadhaar+"\n");
                        fw.write(m.attendance+"\n");
                        fw.write(m.presentAttendance+"\n");
                        fw.write(m.presentleaves+"\n");
                        fw.write(m.target+"\n");
                        fw.write(m.targetMarks+"\n");
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                        newline = br2.readLine();
                    }

                    fw.write(newline+"\n");
                }
                br.close();
                fw.close();
                br2.close();

                a = "Database\\Manage.txt";
                b = "Database\\Test.txt";
                FileReader fr3 = new FileReader(b);
                BufferedReader br3 = new BufferedReader(fr3);
                FileWriter fw3 = new FileWriter(a);
                String output = null;
                while ((output=br3.readLine()) != null) {
                    fw3.write(output+"\n");
                }
                br3.close();
                fw3.close();
            }
                }
                
            }

            catch(Exception e) {
                
            }

                


                if (mainFlag == 0) {
                    try {
                        String a = "Database\\Supervisor.txt";
                        String b = "Database\\Test.txt";
                        FileReader fr = new FileReader(a);
                        BufferedReader br = new BufferedReader(fr);
                        String line = null,newline = null;
                        
                        while ((line = br.readLine()) != null) {
                            if (line.equals(e_id)) {
                                mainFlag = 1;
                                line = br.readLine();
                                System.out.print("Enter password : ");
                                    String e_pass = sc.next();
                                    if (line.equals(e_pass)) {
                                        System.out.println("Password is not correct\n");
                                        return;
                                    }
                                    
                                    System.out.println("\nAuthentication Completed");

                                    Supervisor m = new Supervisor(e_id, e_pass, line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), 
                                    line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), (line=br.readLine()),
                                    (line=br.readLine()), (line=br.readLine()), line=br.readLine(), (line=br.readLine()));
                                    
                                    boolean flag = true;
                                    while(flag == true) {
                                    System.out.println("\nPlease specify the action you want to perform");
                                    System.out.println("1 : View your information");
                                    System.out.println("2 : Mark Today's Attendance");
                                    System.out.println("3 : View present month's attendance");
                                    System.out.println("4 : Apply for leave");
                                    System.out.println("5 : View salary for previous month");
                                    System.out.println("6 : Get present month target details");
                                    System.out.println("7 : Update your information");
                                    System.out.println("8 : Change password");
                                    System.out.println("9 : Apply for resignation");
                                    System.out.println("0 : Exit\n");
                        
                                    int work = sc.nextInt();
                                    switch (work) {
                                        case 1 :
                                            System.out.println();
                                            m.showDetails();
                                            break;
                                        case 2 : 
                                            System.out.println();
                                            m.markAttendance();
                                            break;
                                        case 3 : 
                                            System.out.println();
                                            m.showAttendance();
                                            break;
                                        case 4 : 
                                            System.out.println();
                                            m.getLeaves();
                                            break;
                                        case 5 : 
                                            System.out.println();
                                            m.printSalary();
                                            break;
                                        case 6 : 
                                            System.out.println();
                                            m.getTarget();
                                            break;
                                        case 7 : 
                                            System.out.println();
                                            m.updateDetails();
                                            break;
                                        case 8 : 
                                            System.out.println();
                                            m.changePassword();
                                            break;
                                        case 9 : 
                                            System.out.println();
                                            m.resign();
                                            break;
                                        case 0 : 
                                            System.out.println();
                                            flag = false;
                                            break;
                                        default: 
                                            System.out.println("Please choose a valid option\n");
                                            break;
                                    }
                                }
                            
        
                            // String b = "D:\\2nd_Year_project\\Test.txt";
                            FileReader fr2 = new FileReader(a);
                            BufferedReader br2 = new BufferedReader(fr2);
                        FileWriter fw = new FileWriter(b);
                        while ((newline = br2.readLine())!=null) {
                            if (newline.equals(e_id)) {
                                fw.write(newline+"\n");
                                fw.write(m.password+"\n");
                                fw.write(m.name+"\n");
                                fw.write(m.department+"\n");
                                fw.write(m.dob+"\n");
                                fw.write(m.doj+"\n");
                                fw.write(m.address+"\n");
                                fw.write(m.phone+"\n");
                                fw.write(m.email+"\n");
                                fw.write(m.account+"\n");
                                fw.write(m.aadhaar+"\n");
                                fw.write(m.attendance+"\n");
                                fw.write(m.presentAttendance+"\n");
                                fw.write(m.presentleaves+"\n");
                                fw.write(m.target+"\n");
                                fw.write(m.targetMarks+"\n");
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                            }
        
                            fw.write(newline+"\n");
                        }
                        br.close();
                        fw.close();
                        br2.close();

                        a = "Database\\Supervisor.txt";
                        b = "Database\\Test.txt";
                        FileReader fr3 = new FileReader(b);
                        BufferedReader br3 = new BufferedReader(fr3);
                        FileWriter fw3 = new FileWriter(a);
                        String output = null;
                        while ((output=br3.readLine()) != null) {
                            fw3.write(output+"\n");
                        }
                        br3.close();
                        fw3.close();
                    }
                        }
                        
                    }
        
                    catch(Exception e) {
                        
                    }
        
                        
                }


                if (mainFlag == 0) {
                    try {
                        String a = "Database\\Engineer.txt";
                        String b = "Database\\Test.txt";
                        FileReader frw = new FileReader(a);
                        BufferedReader brw = new BufferedReader(frw);
                        String line = null,newline = null;
                        
                        while ((line = brw.readLine()) != null) {
                            if (line.equals(e_id)) {
                                mainFlag = 1;
                                line = brw.readLine();
                                System.out.print("Enter password : ");
                                    String e_pass = sc.next();
                                    if (line.equals(e_pass)) {
                                        System.out.println("Password is not correct\n");
                                        return;
                                    }
        
                                    System.out.println("\nAuthentication Completed");

                                    Engineer m = new Engineer(e_id, e_pass, line=brw.readLine(), line=brw.readLine(), line=brw.readLine(), line=brw.readLine(), 
                                    line=brw.readLine(), line=brw.readLine(), line=brw.readLine(), line=brw.readLine(), line=brw.readLine(), (line=brw.readLine()),
                                    (line=brw.readLine()), (line=brw.readLine()), line=brw.readLine(), (line=brw.readLine()));
                                    
                                    boolean flag = true;
                                    while(flag == true) {
                                    System.out.println("\nPlease specify the action you want to perform");
                                    System.out.println("1 : View your information");
                                    System.out.println("2 : Mark Today's Attendance");
                                    System.out.println("3 : View present month's attendance");
                                    System.out.println("4 : Apply for leave");
                                    System.out.println("5 : View salary for previous month");
                                    System.out.println("6 : Get present month target details");
                                    System.out.println("7 : Update your information");
                                    System.out.println("8 : Change password");
                                    System.out.println("9 : Apply for resignation");
                                    System.out.println("0 : Exit\n");
                        
                                    int work = sc.nextInt();
                                    switch (work) {
                                        case 1 :
                                            System.out.println();
                                            m.showDetails();
                                            break;
                                        case 2 : 
                                            System.out.println();
                                            m.markAttendance();
                                            break;
                                        case 3 : 
                                            System.out.println();
                                            m.showAttendance();
                                            break;
                                        case 4 : 
                                            System.out.println();
                                            m.getLeaves();
                                            break;
                                        case 5 : 
                                            System.out.println();
                                            m.printSalary();
                                            break;
                                        case 6 : 
                                            System.out.println();
                                            m.getTarget();
                                            break;
                                        case 7 : 
                                            System.out.println();
                                            m.updateDetails();
                                            break;
                                        case 8 : 
                                            System.out.println();
                                            m.changePassword();
                                            break;
                                        case 9 : 
                                            System.out.println();
                                            m.resign();
                                            break;
                                        case 0 : 
                                            System.out.println();
                                            flag = false;
                                            break;
                                        default: 
                                            System.out.println("Please choose a valid option\n");
                                            break;
                                    }
                                }
                            
        
                            // String b = "D:\\2nd_Year_project\\Test.txt";
                            FileReader fr2 = new FileReader(a);
                            BufferedReader br2 = new BufferedReader(fr2);
                        FileWriter fw = new FileWriter(b);
                        while ((newline = br2.readLine())!=null) {
                            if (newline.equals(e_id)) {
                                fw.write(newline+"\n");
                                fw.write(m.password+"\n");
                                fw.write(m.name+"\n");
                                fw.write(m.department+"\n");
                                fw.write(m.dob+"\n");
                                fw.write(m.doj+"\n");
                                fw.write(m.address+"\n");
                                fw.write(m.phone+"\n");
                                fw.write(m.email+"\n");
                                fw.write(m.account+"\n");
                                fw.write(m.aadhaar+"\n");
                                fw.write(m.attendance+"\n");
                                fw.write(m.presentAttendance+"\n");
                                fw.write(m.presentleaves+"\n");
                                fw.write(m.target+"\n");
                                fw.write(m.targetMarks+"\n");
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                            }
        
                            fw.write(newline+"\n");
                        }
                        brw.close();
                        fw.close();
                        br2.close();

                        a = "Database\\Engineer.txt";
                        b = "Database\\Test.txt";
                        FileReader frw1 = new FileReader(b);
                        BufferedReader brw1 = new BufferedReader(frw1);
                        FileWriter fw10 = new FileWriter(a);
                        String output = null;
                        while ((output=brw1.readLine()) != null) {
                            fw10.write(output+"\n");
                        }
                        brw1.close();
                        fw10.close();
                    }
                        }
                        
                    }
        
                    catch(Exception e) {
                        
                    }
        
                        
                }
                

                if (mainFlag == 0) {
                    try {
                        String a = "Database\\Worker.txt";
                        String b = "Database\\Test.txt";
                        FileReader fr = new FileReader(a);
                        BufferedReader br = new BufferedReader(fr);
                        String line = null,newline = null;
                        
                        while ((line = br.readLine()) != null) {
                            if (line.equals(e_id)) {
                                mainFlag = 1;
                                line = br.readLine();
                                System.out.print("Enter password : ");
                                    String e_pass = sc.next();
                                    if (line.equals(e_pass)) {
                                        System.out.println("Password is not correct\n");
                                        return;
                                    }
        
                                    System.out.println("\nAuthentication Completed");

                                    Worker m = new Worker(e_id, e_pass, line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), 
                                    line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), (line=br.readLine()),
                                    (line=br.readLine()), (line=br.readLine()), line=br.readLine(), (line=br.readLine()));
                                    
                                    boolean flag = true;
                                    while(flag == true) {
                                    System.out.println("\nPlease specify the action you want to perform");
                                    System.out.println("1 : View your information");
                                    System.out.println("2 : Mark Today's Attendance");
                                    System.out.println("3 : View present month's attendance");
                                    System.out.println("4 : Apply for leave");
                                    System.out.println("5 : View salary for previous month");
                                    System.out.println("6 : Get present month target details");
                                    System.out.println("7 : Update your information");
                                    System.out.println("8 : Change password");
                                    System.out.println("9 : Apply for resignation");
                                    System.out.println("0 : Exit");
                        
                                    int work = sc.nextInt();
                                    switch (work) {
                                        case 1 :
                                            System.out.println();
                                            m.showDetails();
                                            break;
                                        case 2 : 
                                            System.out.println();
                                            m.markAttendance();
                                            break;
                                        case 3 : 
                                            System.out.println();
                                            m.showAttendance();
                                            break;
                                        case 4 : 
                                            System.out.println();
                                            m.getLeaves();
                                            break;
                                        case 5 : 
                                            System.out.println();
                                            m.printSalary();
                                            break;
                                        case 6 : 
                                            System.out.println();
                                            m.getTarget();
                                            break;
                                        case 7 : 
                                            System.out.println();
                                            m.updateDetails();
                                            break;
                                        case 8 : 
                                            System.out.println();
                                            m.changePassword();
                                            break;
                                        case 9 : 
                                            System.out.println();
                                            m.resign();
                                            break;
                                        case 0 : 
                                            System.out.println();
                                            flag = false;
                                            break;
                                        default: 
                                            System.out.println("Please choose a valid option");
                                            break;
                                    }
                                }
                            
        
                            // String b = "D:\\2nd_Year_project\\Test.txt";
                            FileReader fr2 = new FileReader(a);
                            BufferedReader br2 = new BufferedReader(fr2);
                        FileWriter fw = new FileWriter(b);
                        while ((newline = br2.readLine())!=null) {
                            if (newline.equals(e_id)) {
                                fw.write(newline+"\n");
                                fw.write(m.password+"\n");
                                fw.write(m.name+"\n");
                                fw.write(m.department+"\n");
                                fw.write(m.dob+"\n");
                                fw.write(m.doj+"\n");
                                fw.write(m.address+"\n");
                                fw.write(m.phone+"\n");
                                fw.write(m.email+"\n");
                                fw.write(m.account+"\n");
                                fw.write(m.aadhaar+"\n");
                                fw.write(m.attendance+"\n");
                                fw.write(m.presentAttendance+"\n");
                                fw.write(m.presentleaves+"\n");
                                fw.write(m.target+"\n");
                                fw.write(m.targetMarks+"\n");
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                                newline = br2.readLine();
                            }
        
                            fw.write(newline+"\n");
                        }
                        br.close();
                        fw.close();
                        br2.close();

                        a = "Database\\Worker.txt";
                        b = "Database\\Test.txt";
                        FileReader fr3 = new FileReader(b);
                        BufferedReader br3 = new BufferedReader(fr3);
                        FileWriter fw3 = new FileWriter(a);
                        String output = null;
                        while ((output=br3.readLine()) != null) {
                            fw3.write(output+"\n");
                        }
                        br3.close();
                        fw3.close();
                    }
                        }
                        
                    }
        
                    catch(Exception e) {
                        
                    }
        
                        
                }


                if (mainFlag == 0) {
                    System.out.println("The entered ID does not exist\n");
                }

                
                break;
            default: System.out.println("Provide valid input");
                break;
        }
    }
}
