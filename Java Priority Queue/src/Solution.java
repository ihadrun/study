import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student>{
private double cgpa;
private String name;
private int id;
public Student(String name, double cgpa, int id) {
this.name= name;
this.cgpa=cgpa;this.id=id; }


	@Override
	public int compareTo(Student o) {
		if(cgpa<o.cgpa) return -1;
		else if(cgpa>o.cgpa) return 1;
		
		
		// TODO Auto-generated method stub
		return 0;
		public int getID() {
			try {
				return this.id;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public String getName() {
			try {
				return this.name;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public double getCGPA() {
			try {
				return this.cgpa;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public class Priorities() {
		
		//azaghi
		return 1;
	}
	
}
/*
 * Create the Student and Priorities classes here.
 */


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}