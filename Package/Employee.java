package Package;
import Package.EmployeeWork;
import java.util.Scanner;

public class Employee implements EmployeeWork {
    
    public String department;
    public String name;
    String id;
    public String password;
    public String dob;
    public String doj;
    public String address;
    public String phone;
    public String email;
    public String account;
    public String aadhaar;

    public String attendance;
    public String presentAttendance;
    public String presentleaves;
    public String targetMarks;
    public String target;

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
        System.out.print("Enter your date of birth in the format dd/mm/yyyy : ");
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
    public void printSalary() {

    }
}
