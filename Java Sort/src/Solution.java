import java.util.*;

class AlphabeticalComparator implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        // TODO Auto-generated method stub
        if(o2.getCgpa()>o1.getCgpa()) {return 1;}
        else if((o2.getCgpa()==o1.getCgpa())){
            return o1.getFname().compareTo(o2.getFname());}
            else if((o2.getCgpa()==o1.getCgpa())&&o1.getFname().compareTo(o2.getFname())==0) {
            if(o2.getId()>o1.getId()) {return 1;}
            }
      
        return -1;
        
        
    }
    
}

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			 
			
			Student st = new Student(id, fname, cgpa);
			 
			studentList.add(st);
			
			testCases--;
			
		}
		Collections.sort(studentList, new AlphabeticalComparator() );
    
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}



