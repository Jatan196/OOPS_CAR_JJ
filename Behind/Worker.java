package Package;
import Package.Employee;

public class Worker extends Employee {
    int basic = 12000;

    public Worker(String id, String password, String name, String department, String dob, String doj, String address, 
    String phone, String email, String account, String aadhaar, String attendance, String presentAttendance, String presentleaves, 
    String target, String targetMarks) {
    super(id, password, name, department, dob, doj, address, phone, email, account, aadhaar, attendance, presentAttendance, 
    presentleaves, target, targetMarks);
    }

    public void showDetails() {
        System.out.println("The details available for the Employee Id "+id+" are :");
        System.out.println("Name : "+name);
        System.out.println("Post : Worker");
        System.out.println("Department : "+department);
        System.out.println("Date of Birth : "+dob);
        System.out.println("Date of Joining : "+doj);
        System.out.println("Address : "+address);
        System.out.println("Phone number : "+phone);
        System.out.println("Email : "+email);
        System.out.println("Aadhaar : "+aadhaar);
    }

    public void printSalary() {
        int a = Integer.parseInt(attendance);
        int tm = Integer.parseInt(targetMarks);
        int salary = basic*a/26 + 1500*tm;
        System.out.println("Your salary for the previous month is : "+salary+"\n");
    }
}

