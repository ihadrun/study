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

public int compareTo(Student st) {  
    if(id>st.id){  
        return 1;  
    }else if(id<st.id){  
        return -1;  
    }else{  
    return 0;  
    }  
}

public char[] getName() {
	// TODO Auto-generated method stub
	return ;
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