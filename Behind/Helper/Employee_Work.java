import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

interface Employee_Work {
    void printSalary();
    void markAttendance();
    void getLeaves();
    void changePassword();
    void updateDetails();
    void getTarget();
    void showDetails();
    void resign();
}

class Employee implements Employee_Work {
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
    String dol;

    int attendance;
    int salary;
    int leaves;
    double targetMarks;
    String target;

    Employee(String department, String name, String id, String password, String dob, String doj, String address, 
             String phone, String email, String account, String aadhaar) {
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
    }

    Scanner sc = new Scanner(System.in);
    public void changePassword() {
        System.out.print("Enter your date of birth : ");
        String test_dob = sc.next();
        if (test_dob == dob) {
            System.out.print("Enter new password : ");
            Scanner sc = new Scanner(System.in);
            String newp = sc.next();
            password = newp;
        }
        else {
            System.out.println("The entered date of birth is not correct \n");
        }
    }

    public void showDetails() {
        System.out.println("The details available for the Employee Id "+id+" are :\n");
        System.out.println("Name : "+name);
        System.out.println("Department : "+department);
        System.out.println("dob : "+dob);
        System.out.println("Address"+address);
        System.out.println("Phone number : "+phone);
        System.out.println("Email : "+email);
    }

    public void updateDetails() {
        System.out.println("Enter the code of information you want to update : ");
        System.out.println("Address : 1");
        System.out.println("Phone number : 2");
        System.out.println("Email Address : 3");
        System.out.println("Account Number : 4");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Enter the new address : ");
                address = sc.next();
                break;
        
            case 2:
                System.out.println("Enter the new phone number : ");
                phone = sc.next();
                break;

            case 3:
                System.out.println("Enter new email address : ");
                email = sc.next();
                break;

            case 4:
                System.out.println("Enter the new account number : ");
                account = sc.next();
                break;

            default:
                System.out.println("Please choose a valid option.");
                break;
        }
    }

    public void getLeaves() {
        System.out.println(leaves);
    }

    public void getTarget() {
        System.out.println(target);
    }

    public void markAttendance() {
        attendance += 1;
    }

    public void resign() {
        System.out.println("Resignation request forwarded");
    }
    public void printSalary() {}
}

class Manager extends Employee {
    int basic = 57000;

    Manager(String department, String name, String id, String password, String dob, String doj, String address, 
    String phone, String email, String account, String aadhaar) {
    super(department, name, id, password, dob, doj, address, phone, email, account, aadhaar);
    }

    public void printSalary() {
        System.out.println(basic*attendance/26+(15000*targetMarks));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager emp[] = new Manager[100];
        int emppinter = 0;
        System.out.println("Welcome to JATANJAY CARS Pvt. Ltd.\n");
        System.out.println("If you are a Customer : Press 1");
        System.out.println("If you are an Employee : Press 2");
        Manager JJ1542023M17 = new Manager("Engine", "Piyush Gurjar", "JJ1542023M17", "JayP", 
                                "14/5/2001", "17/8/2023", "718_Pithampur", "4578451269", 
                                    "jay@gmail.com", "1234", "457895641257");
        
        JJ1542023M17.attendance = 24;
        JJ1542023M17.leaves = 2;
        JJ1542023M17.target = "Complete the auto fuel injection project";
        JJ1542023M17.targetMarks = 0.8;
        emp[emppinter] = JJ1542023M17;
        int type = sc.nextInt();
        switch (type) {
            case 1:
                System.out.println("Not created yet\n");
                break;
            case 2 : 
                System.out.println("Kindly enter your id");
                String e_id = sc.next();
                int flag = 0;
                for (int i = 0; i < emp.length; i++) {
                    if (emp[i].id == e_id) {
                        flag = 1;
                        System.out.println("Enter password : ");
                        String e_pass = sc.next();
                        if (emp[i].password == e_pass) {
                            System.out.println("Authemtication Completed");
                            System.out.println("Please specify the action you want to perform");
                            System.out.println("1 : View your information");
                            System.out.println("2 : Mark Today's Attendance");
                            System.out.println("3 : View previous month's attendance");
                            System.out.println("4 : View leaves of previous month");
                            System.out.println("5 : View salary for previous month");
                            System.out.println("6 : Get present month target details");
                            System.out.println("7 : Update your information");
                            System.out.println("8 : Change password");
                            System.out.println("9 : Apply for resignation");
                
                            int work = sc.nextInt();
                            switch (work) {
                                case 1 :
                                    emp[i].showDetails();
                                    break;
                                case 2 : 
                                    emp[i].markAttendance();
                                    break;
                                case 3 : 
                                    System.out.println(emp[i].attendance);
                                    break;
                                case 4 : 
                                    emp[i].getLeaves();
                                    break;
                                case 5 : 
                                    emp[i].printSalary();
                                    break;
                                case 6 : 
                                    emp[i].getTarget();
                                    break;
                                case 7 : 
                                    emp[i].updateDetails();
                                    break;
                                case 8 : 
                                    emp[i].changePassword();
                                    break;
                                case 9 : 
                                    emp[i].resign();
                                    break;
                                default: 
                                    System.out.println("Please choose a valid option");
                                    break;
                            }
                        }
                        else {
                            System.out.println("Incorrect password");
                        }
                    }
                    if (flag == 0) {
                        System.out.println("Id doesn't exist");
                    }
                }
                
                break;
            default: System.out.println("Provide valid input");
                break;
        }
    }
}