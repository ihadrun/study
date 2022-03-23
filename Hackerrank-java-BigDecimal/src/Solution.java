import java.math.BigDecimal;
import java.util.*;
class Solution{

    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        for(int i=0;i<n;i++) {
              for(int j=i+1;j<n;j++) {
            	  if (BigDecimal(s[j]).compareTo(BigDecimal(s[i])) == 1) {
               String temp =s[i];
               s[i]=s[j];
               s[j]=temp;
                    }
         
              }
           }
       
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

	private static BigDecimal BigDecimal(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}