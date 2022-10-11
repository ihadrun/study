import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Student implements Comparable<Student>{
private double cgpa;
private String name;
private int id;
public Student(String name, double cgpa, int id) {
this.name= name;
this.cgpa=cgpa;this.setId(id); }

public int compareTo(Student st) {  
    if(getId()>st.getId()){  
        return 1;  
    }else if(getId()<st.getId()){  
        return -1;  
    }else{  
    return 0;  
    }  
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


	
	
}

public class Solution {

 public static void main(String[] args) {
	 Queue<Student> queue=new PriorityQueue<Student>();  
        Scanner s = new Scanner(System.in);
        Student st1=new Student("Yashwant Kanetkar",542,8);  
        Student st3=new Student("Yashwafnt Kanetkar",5452,86);  
        Student st2=new Student("Yashwant Kanetkar",5342,84);  
        
        queue.add(st1);  
        queue.add(st3);  
        queue.add(st2);  
        System.out.println("Traversing the queue elements:");  
        for(Student st:queue){  
            System.out.println(st.getId());  
            }  
        


//Write your code here

    }
}
