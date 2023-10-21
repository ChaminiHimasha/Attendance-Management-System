import java.util.Scanner;

class Student {
    private String name;
    private String regNo;
    private String course;

    public Student(String name, String regNo, String course) {
        this.name = name;
        this.regNo = regNo;
        this.course = course;
    }

    public String getName() {
        return name;
    }
	public void setName(String name)
	{
		this.name=name;
	}

    public String getRegNo() {
        return regNo;
    }
	public void setRegNo(String regNo){
		this.regNo=regNo;
	}

    public String getCourse() {
        return course;
    }
	public void setCourse(String course){
		this.course=course;
	}
}

class Attendance extends Student {
    private int presentCount;
    private int totalClasses;

    public Attendance(String name, String regNo, String course) {
        super(name, regNo, course);
    }

    public void setAttendanceData(int presentCount, int totalClasses) {
        this.presentCount = presentCount;
        this.totalClasses = totalClasses;
    }

    public double calculateAttendancePercentage() {
        return (double) presentCount / totalClasses * 100;
    }
	
	public void checkValidity(){
		if(calculateAttendancePercentage()>=80){
			System.out.println(" "+getRegNo()+" - "+getName()+"  can sit for "+getCourse()+" exam");
		}
		else{
			System.out.println(" ## Result:  "+getRegNo()+" - "+getName()+"  cannot sit for "+getCourse()+" exam");
		}
		
	}

    public void printStudentDetails() {
        System.out.println("\n		---Student Details:---");
        System.out.println("\n Name: " + getName());
        System.out.println("\n Register Number: " + getRegNo());
        System.out.println("\n Course name: " + getCourse());
        System.out.println("\n Attendance Percentage: " + calculateAttendancePercentage() + "%\n");
		checkValidity();
		System.out.println("\n..................................................................");
    }
}

public class AttendanceManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
		
		System.out.println("\n..................................................................");
		
		System.out.println("\n		****ATTENDANCE MANAGEMENT SYSTEM***\n");

        System.out.print("\n Enter student name: ");
        String studentName = input.nextLine();

        System.out.print("\n Enter register number: ");
        String regNo = input.nextLine();

        System.out.print("\n Enter course name: ");
        String courseName = input.nextLine();

        System.out.print("\n Enter present count: ");
        int presentCount = input.nextInt();

        System.out.print("\n Enter total classes: ");
        int totalClasses = input.nextInt();

        Attendance attendance = new Attendance(studentName, regNo, courseName);
        attendance.setAttendanceData(presentCount, totalClasses);
        attendance.printStudentDetails();
    }
}