import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in); 
		Stack<Integer> STACK = new Stack<Integer>();
		int a = sc.nextInt();
		 String k = "Insert";
		 String l= "Delete";
		for ( int i=0;i<a;i++)
		{
			 int number = sc.nextInt();
	            	STACK.push(number);
			
		// TODO Auto-generated method stub

	}
		
		 int t = sc.nextInt();
		 for ( int j=0; j <t;j++)
	 {
			 String u=sc.next();
			
			 if(u.equals(k)) {
				 
		 int c = sc.nextInt();
		 int b = sc.nextInt();
		 
		 
		 STACK.insertElementAt(b, c);
		 }
			 else if(u.equals(l)){
				
			 
		 int d = sc.nextInt();
		 Integer rem_ele = STACK.remove(d);
		 
		 System.out.println("Final2 Stack: "
                 + STACK);
		 System.out.println(Arrays.toString(STACK.toArray()));
			}
		 }
			 

}
	}


