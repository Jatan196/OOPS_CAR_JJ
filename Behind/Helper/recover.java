import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class recover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to JATANJAY CARS Pvt. Ltd.\n");
        System.out.println("If you are a Customer : Press 1");
        System.out.println("If you are an Employee : Press 2");
        int type = sc.nextInt();
        switch (type) {
            case 1:
                System.out.println("Not created yet\n");
                break;
            case 2 : 
                System.out.print("Kindly enter your id : ");
                String e_id = sc.next();
                try {
                String a = "D:\\2nd_Year_project\\Manage.txt";
                String b = "D:\\2nd_Year_project\\Test.txt";
                FileReader fr = new FileReader(a);
                BufferedReader br = new BufferedReader(fr);
                String line = null,newline = null;
                int flag1 = 0;
                while ((line = br.readLine()) != null) {
                    if (line.compareTo(e_id)==0) {
                        flag1 = 1;
                        line = br.readLine();
                        System.out.print("Enter password : ");
                            String e_pass = sc.next();
                            if (line.compareTo(e_pass)!=0) {
                                System.out.println("Password is not correct\n");
                                return;
                            }

                            Manager m = new Manager(e_id, e_pass, line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), 
                            line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), line=br.readLine(), (line=br.readLine()),
                            (line=br.readLine()), (line=br.readLine()), line=br.readLine(), (line=br.readLine()));
                            
                            boolean flag = true;
                            while(flag == true) {
                            System.out.println("Please specify the action you want to perform");
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
                                    m.showDetails();
                                    break;
                                case 2 : 
                                    m.markAttendance();
                                    break;
                                case 3 : 
                                    m.showAttendance();
                                    break;
                                case 4 : 
                                    m.getLeaves();
                                    break;
                                case 5 : 
                                    m.printSalary();
                                    break;
                                case 6 : 
                                    m.getTarget();
                                    break;
                                case 7 : 
                                    m.updateDetails();
                                    break;
                                case 8 : 
                                    m.changePassword();
                                    break;
                                case 9 : 
                                    m.resign();
                                    break;
                                case 0 : 
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
                    if (newline.compareTo(e_id)==0) {
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
            }
                }
                if (flag1 == 0) {
                    System.out.println("Entered id is not present\n");
                }
            }

            catch(Exception e) {
                
            }

                try {
                    String a = "D:\\2nd_Year_project\\Manage.txt";
                    String b = "D:\\2nd_Year_project\\Test.txt";
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

                catch(Exception i) {
                    
                }

                // }

                // catch(Exception e) {
                //     e.printStackTrace();
                // }
                
                break;
            default: System.out.println("Provide valid input");
                break;
        }
    }
}

interface EmployeeWork {
    void printSalary();
    void markAttendance();
    void showAttendance();
    void getLeaves();
    void changePassword();
    void updateDetails();
    void getTarget();
    void showDetails();
    void resign();
}

class Employee implements EmployeeWork {
    String department;
    String name;
    String id;
    String password;
    String dob;
    String doj;
    String address;
    String phone;
    String email;
    String account;
    String aadhaar;

    String attendance;
    String presentAttendance;
    String presentleaves;
    String targetMarks;
    String target;

    Employee(String id, String password, String name, String department, String dob, String doj, String address, 
             String phone, String email, String account, String aadhaar, String attendance, String presentAttendance, String presentleaves, 
             String target, String targetMarks) {
        this.department = department;
        this.name = name;
        this.id = id;
        this.password = password;
        this.dob = dob;
        this.doj = doj;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.account = account;
        this.aadhaar = aadhaar;
        this.attendance = attendance;
        this.presentAttendance = presentAttendance;
        this.presentleaves = presentleaves;
        this.target = target;
        this.targetMarks = targetMarks;
    }

    Scanner sc = new Scanner(System.in);
    public void changePassword() {
        System.out.print("Enter your date of birth : ");
        String test_dob = sc.next();
        if (test_dob.compareTo(dob) == 0) {
            System.out.print("Enter new password : ");
            Scanner sc = new Scanner(System.in);
            String newp = sc.next();
            password = newp;
            System.out.println("Password changed successfully\n");
        }
        else {
            System.out.println("The entered date of birth is not correct \n");
        }
    }

    public void showDetails() {
        System.out.println("The details available for the Employee Id "+id+" are :");
        System.out.println("Name : "+name);
        System.out.println("Department : "+department);
        System.out.println("Date of Birth : "+dob);
        System.out.println("Date of Joining : "+doj);
        System.out.println("Address"+address);
        System.out.println("Phone number : "+phone);
        System.out.println("Email : "+email);
        System.out.println("Aadhaar : \n"+aadhaar);
    }

    public void updateDetails() {
        System.out.println("Choose the information you want to update : ");
        System.out.println("Address : 1");
        System.out.println("Phone number : 2");
        System.out.println("Email Address : 3");
        System.out.println("Account Number : 4");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.print("Enter the new address : ");
                address = sc.next();
                System.out.println("Address updated successfully\n");
                break;
        
            case 2:
                System.out.print("Enter the new phone number : ");
                phone = sc.next();
                System.out.println("Phone number updated successfully\n");
                break;

            case 3:
                System.out.print("Enter the new email address : ");
                email = sc.next();
                System.out.println("Email updated successfully\n");
                break;

            case 4:
                System.out.print("Enter the new account number : ");
                account = sc.next();
                System.out.println("Account number updated successfully\n");
                break;

            default:
                System.out.println("Please choose a valid option\n");
                break;
        }
    }

    public void getLeaves() {
        System.out.println("How many leaves you want : ");
        int s = sc.nextInt();
        int l = Integer.parseInt(presentleaves);
        l += s;
        presentleaves = Integer.toString(l);
        System.out.println("Leaves granted\n");
    }

    public void getTarget() {
        System.out.println("Your present month target is : "+target);
    }

    public void markAttendance() {
        int a = Integer.parseInt(presentAttendance);
        a++;
        presentAttendance = Integer.toString(a);
        System.out.println("Attendance marked\n");
    }

    public void showAttendance() {
        int a = Integer.parseInt(presentAttendance);
        int l = Integer.parseInt(presentleaves);
        System.out.println("Your present attendance is "+a+" out of "+(a+l)+" days\n");
    }

    public void resign() {
        id = "\n";
        password = "0";
        name = "0";
        department = "0";
        dob = "0";
        doj = "0";
        address = "0";
        phone = "0";
        email = "0";
        account = "0";
        aadhaar = "0";
        attendance = "0";
        presentAttendance = "0";
        presentleaves = "0";
        target = "0";
        targetMarks = "0";
        System.out.println("Resignation accepted");
    }
    public void printSalary() {}
}

class Manager extends Employee {
    int basic = 80000;

    Manager(String id, String password, String name, String department, String dob, String doj, String address, 
    String phone, String email, String account, String aadhaar, String attendance, String presentAttendance, String presentleaves, 
    String target, String targetMarks) {
    super(id, password, name, department, dob, doj, address, phone, email, account, aadhaar, attendance, presentAttendance, 
    presentleaves, target, targetMarks);
    }

    public void printSalary() {
        int a = Integer.parseInt(attendance);
        int tm = Integer.parseInt(targetMarks);
        int salary = basic*a/26 + 10000*tm;
        System.out.println("Your salary for the previous month is : \n"+salary);
    }
}

class Supervisor extends Employee {
    int basic = 50000;

    Supervisor(String id, String password, String name, String department, String dob, String doj, String address, 
    String phone, String email, String account, String aadhaar, String attendance, String presentAttendance, String presentleaves, 
    String target, String targetMarks) {
    super(id, password, name, department, dob, doj, address, phone, email, account, aadhaar, attendance, presentAttendance, 
    presentleaves, target, targetMarks);
    }

    public void printSalary() {
        int a = Integer.parseInt(attendance);
        int tm = Integer.parseInt(targetMarks);
        int salary = basic*a/26 + 6000*tm;
        System.out.println("Your salary for the previous month is : \n"+salary);
    }
}

class Engineer extends Employee {
    int basic = 25000;

    Engineer(String id, String password, String name, String department, String dob, String doj, String address, 
    String phone, String email, String account, String aadhaar, String attendance, String presentAttendance, String presentleaves, 
    String target, String targetMarks) {
    super(id, password, name, department, dob, doj, address, phone, email, account, aadhaar, attendance, presentAttendance, 
    presentleaves, target, targetMarks);
    }

    public void printSalary() {
        int a = Integer.parseInt(attendance);
        int tm = Integer.parseInt(targetMarks);
        int salary = basic*a/26 + 3000*tm;
        System.out.println("Your salary for the previous month is : \n"+salary);
    }
}

class Worker extends Employee {
    int basic = 12000;

    Worker(String id, String password, String name, String department, String dob, String doj, String address, 
    String phone, String email, String account, String aadhaar, String attendance, String presentAttendance, String presentleaves, 
    String target, String targetMarks) {
    super(id, password, name, department, dob, doj, address, phone, email, account, aadhaar, attendance, presentAttendance, 
    presentleaves, target, targetMarks);
    }

    public void printSalary() {
        int a = Integer.parseInt(attendance);
        int tm = Integer.parseInt(targetMarks);
        int salary = basic*a/26 + 1500*tm;
        System.out.println("Your salary for the previous month is : \n"+salary);
    }
}

