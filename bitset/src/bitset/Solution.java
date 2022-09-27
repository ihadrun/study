

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
         
         for(int i=0;i<M;i++) {
         String s = sc.next();
         int w =sc.nextInt();
         int q= sc.nextInt();
         
        switch(s) {
       case "AND":
          if(w==1) {
          B1.and(B2);
          
    }
          else  B2.and(B1);break;
    case "OR":
        if(w==1) B1.or(B2);
        else B2.or(B1);break;
        case "FLIP":if(w==1)B1.flip(q);
       else B2.flip(q);break;
        case "SET":
            if(w==1)B1.set(q);else B2.set(q);break;
         case "XOR":
             if(w==1) B1.xor(B2);
             else B2.xor(B1);break;}
        
         
       System.out.println(B1.cardinality()+" "+B2.cardinality());
         }
         
    }
}