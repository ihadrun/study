package java2;

import java.util.*;


public class Main {
	
	public static int dislikedString(String S,int N, String[] A)
	{    
  System.out.println(A[0]);
  String a = A[0];
  
  
   for(int i=0;i<S.length();i++)
   {
	   
	   for(int j=0;j<a.length();j++) {
		   char c = S.charAt(i);
		   char d =a.charAt(j);
		   if(c==d) {int count =+1;}
		   else {int count=1;};
		  
		   
		   
	   }
	   
   }
    return 1;
		
	}
   public static void main(String []args) {
	   
	   Scanner sc = new Scanner(System.in);
	   String S= sc.next();
	   int N = sc.nextInt();
	   String[]A = new String[N];
	   for (int i= 0;i<N;i++)
	   {
		   A[i]=sc.next();
		  // System.out.println(A[i]+" ");
	   }
	   sc.close();
System.out.println(dislikedString(S,N,A));
	   
	   
  
      
      
   }
}