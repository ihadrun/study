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
this.setName(name);
this.setCgpa(cgpa);this.setId(id); }

public int compareTo(Student st) {  
    if(getCgpa()>st.getCgpa()){  
        return 1;  
    }else if(getCgpa()<st.getCgpa()){  
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

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getCgpa() {
	return cgpa;
}

public void setCgpa(double cgpa) {
	this.cgpa = cgpa;
}




	
	
}

public class Solution {

 public static void main(String[] args) {
	 Queue<Student> queue=new PriorityQueue<Student>();  
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        
        for (int i = 0; i< t; i++) {
        	String f= s.next();
        	if(f.equals("ENTER"))
        	{
        		 Student st=new Student(s.next(),s.nextDouble(), s.nextInt()); 
        		 queue.add(st);  
        	}
        	else if(f.equals("SERVED")) {
        		queue.remove();
        		
        	}
        	
        }
      
        
      
       
        
        System.out.println("Traversing the queue elements:");  
        for(Student st:queue){  
            System.out.println(st.getName());  
            }  
        
        System.out.println("Treaversing the queue elements:");  
        for(Student st:queue){  
            System.out.println(st.getCgpa());  
            } 
        


//Write your code here

    }
}
