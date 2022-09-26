package bitset;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	  BitSet B1 = new BitSet(N);
          BitSet B2 = new BitSet(N);
         String s = sc.next();
          for(int i=0;i<M; i++) {
        	  switch(s) {
        	  case "AND":
        		  B1.and(B2);
        	    // code block
        	    break;
        	  case "OR":
        		  B1.or(B2);
        	  case "FLIP":
        		  B1.flip(bitIndex);
        	    // code block
        	    break;
        	  default:
        	    // code block
        	}
              B1.set(i);
        }
          System.out.println("bs1  : " + B1);
        B1.set(0, 2);
          
      
          System.out.println("bs1  : " + B1);
          System.out.println(B1.cardinality());
    	
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}